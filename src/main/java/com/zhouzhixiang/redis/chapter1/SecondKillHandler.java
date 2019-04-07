package com.zhouzhixiang.redis.chapter1;

import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

public class SecondKillHandler implements Runnable {

    String key = ""; // 监视的key 当前秒杀商品的数量

    Goods goods;
    Jedis jedis;
    Person person;

    public SecondKillHandler(Goods goods, Person person) {
        this.goods = goods;
        this.person = person;
        key = "goods:" + goods.getGoodsname();
    }

    @Override
    public void run() {
//        while (true) {
            try {
                jedis = RedisUtil.getJedis();
                // watch 监视此key，当事务执行之前这个key发生了改变，事务就会被打断
                jedis.watch(key);
                // 当前剩余商品的数量
                int currentGoodsCount = Integer.parseInt(jedis.get(key));
                if (currentGoodsCount < 0) {
                    System.out.println("商品已抢完，" +person.getUsername()+"--->抢购失败" );
//                    break;
                }
                // 开启事务
                Transaction transaction = jedis.multi();
                // 商品数量减1
                transaction.incrBy(key, -1);
                // 执行事务
                List<Object> exec = transaction.exec();
                if (CollectionUtils.isEmpty(exec)) {
                    System.out.println(person.getUsername() + "---> 抢购失败，继续抢购");
                    Thread.sleep(1);
                } else {
                    exec.forEach(succ -> {
                        String successStr = person.getUsername()
                                + "====> 成功抢购到编号【"+((100 - currentGoodsCount) + 1)+"】商品，"
                                + "该商品剩余："+succ.toString() ;
                        System.out.println(successStr);
                        jedis.set("goodsResult:"+person.getUsername(),successStr);
                    });
//                    break;
                }
            } catch (InterruptedException e) {
                RedisUtil.returnResource(jedis);
                e.printStackTrace();
            } finally {
                // 此处需要注意，并发环境下，当前的jedis可能已经被其他线程所归还并且取消监视
                if (jedis != null) {
                    jedis.unwatch();
                    RedisUtil.returnResource(jedis);
                }
            }
//        }
    }
}
