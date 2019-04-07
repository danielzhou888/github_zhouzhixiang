package com.scmd.redis.chapter2;

import com.zhouzhixiang.ZhouzhixiangApplication;
import com.zhouzhixiang.redis.chapter2.RedisUtil;
import com.zhouzhixiang.redis.chapter2.SecondKillHandler;
import com.zhouzhixiang.redis.chapter2.SecondKillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZhouzhixiangApplication.class)
@WebAppConfiguration
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Resource
    private SecondKillService secondKillService;

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void test() {
        logger.info("开始");
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        IntStream.rangeClosed(1, 100).forEach(i -> {
            executorService.execute(new SecondKillHandler(secondKillService, redisUtil, "MSKEY"));
        });
    }
}
