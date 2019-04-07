package com.zhouzhixiang.redis.chapter2;

import com.zhouzhixiang.ZhouzhixiangApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZhouzhixiangApplication.class)
@WebAppConfiguration
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Autowired
    private SecondKillService secondKillService;

    @Autowired
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
