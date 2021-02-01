package com.hbr;

import com.aliyuncs.exceptions.ClientException;
import com.hbr.redis.service.RedisService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class HbrDiskApplicationTests {
    Logger logger= LoggerFactory.getLogger(HbrDiskApplicationTests.class);
    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSms() throws ClientException {
        redisService.set("ces",1);
    }


}
