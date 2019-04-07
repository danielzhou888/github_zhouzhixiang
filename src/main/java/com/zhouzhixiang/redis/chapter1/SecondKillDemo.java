package com.zhouzhixiang.redis.chapter1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 秒杀处理测试
 */
public class SecondKillDemo {

    private static Jedis jedis;
    protected static final Logger logger = LoggerFactory.getLogger(JedisPool.class);

    @Test
    public void test() throws InterruptedException, IOException {
        /** 初始化商品 */
        initGoodsToRedis();

        logger.info("init goods success ........");

        /** 1000线程抢购100个商品 */
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        long startTime = System.currentTimeMillis();
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//            executorService.execute(new SecondKillHandler(
//                    new Goods(null, "iphoneX", 9999.00),
//                    new Person("zhouzhixiang-"+i)));
//            countDownLatch.countDown();
//        });

        for (int i = 0; i < 100; i++) {
            executorService.execute(new SecondKillHandler(
                    new Goods(null, "iphoneX", 9999.00),
                    new Person("zhouzhixiang-"+i)));
            countDownLatch.countDown();
        }
        executorService.shutdown();
        countDownLatch.await();
        long time = System.currentTimeMillis() - startTime;
        System.out.println("共耗时：" + time + "毫秒");
        RedisUtil.close();
        System.in.read();
    }

    /**
     * 初始化商品数量
     */
    public void initGoodsToRedis() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.set("goods:iphoneX", "100");
        RedisUtil.returnResource(jedis);
    }

}
