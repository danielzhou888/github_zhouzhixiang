package com.zhouzhixiang.redis.chapter1;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: scmd-knb-common
 * @description:
 * @author: zhouzhixiang
 * @create: 2019-04-01 19:46
 */
public class RedisUtil {


    private static JedisPool pool = null;
    protected static final Logger logger = LoggerFactory.getLogger(JedisPool.class);
    protected static ReentrantLock lockPool = new ReentrantLock();
    protected static ReentrantLock lockJedis = new ReentrantLock();


    /**
     * redis过期时间,以秒为单位
     */
    public final static int EXRP_HOUR = 60*60;          //一小时
    public final static int EXRP_DAY = 60*60*24;        //一天
    public final static int EXRP_MONTH = 60*60*24*30;   //一个月

    /**
     * Jedis池
     */
    public static void initialPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大连接数（100个足够用了，没必要设置太大）
        config.setMaxTotal(100);
        //获取Jedis连接的最大等待时间（50秒）
        config.setMaxWaitMillis(50 * 1000);
        //在获取Jedis连接时，自动检验连接是否可用
        config.setTestOnBorrow(true);
        //在将连接放回池中前，自动检验连接是否有效
        config.setTestOnReturn(true);
        //自动测试池中的空闲连接是否都是可用连接
        config.setTestWhileIdle(true);
        //最大空闲连接数
        config.setMaxIdle(10);
        //创建连接池
        pool = new JedisPool(config, "10.100.1.46", 6379, 2000, null, 0);
    }

    /**
     * 在多线程环境同步初始化
     */
    private static void initpool() {
        //断言 ，当前锁是否已经锁住，如果锁住了，就啥也不干，没锁的话就执行下面步骤
        assert ! lockPool.isHeldByCurrentThread();
        lockPool.lock();
        try {
            if (pool == null) {
                initialPool();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPool.unlock();
        }
    }

    public static Jedis getJedis() {
        assert ! lockJedis.isHeldByCurrentThread();
        lockJedis.lock();
        if (pool == null) {
            initpool();
        }
        Jedis jedis = null;
        try {
            if (pool != null) {
                jedis = pool.getResource();
                return jedis;
            }
        } catch (Exception e) {
            returnResource(jedis);
            logger.error("get jedis error: {}", e);
        } finally {
//            returnResource(jedis);
            lockJedis.unlock();
        }
        return null;
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null && pool != null) {
            jedis.close();
        }
    }

    /**
     * set string
     * @param key
     * @param value
     */
    public synchronized static void setString(String key, String value) {
        try {
            value = StringUtils.isEmpty(value) ? "" : value;
            getJedis().set(key, value);
        } catch (Exception e) {
            logger.error("Set key error: {}", e);
        }
    }

    /**
     * set string with expire time
     * @param key
     * @param seconds
     * @param value
     */
    public synchronized static void setString(String key, int seconds, String value) {
        try {
            value = StringUtils.isEmpty(value) ? "" : value;
            getJedis().setex(key, seconds, value);
        } catch (Exception e) {
            logger.error("Set keyex error: {}", e);
        }
    }

    /**
     * get string
     * @param key
     * @return
     */
    public synchronized static String getString(String key) {
        Jedis jedis = getJedis();
        if (jedis == null || !getJedis().exists(key)) {
            return null;
        }
        return jedis.get(key);
    }

    /**
     * 关闭jedis连接池
     */
    public synchronized static void close() {
        if (pool != null) {
            pool.close();
        }
    }
}
