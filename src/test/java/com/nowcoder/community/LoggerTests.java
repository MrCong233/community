package com.nowcoder.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoggerTests {

    //实例化Loger接口
    //输入为一个类，类名就是Logger的名字，用于区别不同的logger，一般使用主类
    private static final Logger logger = LoggerFactory.getLogger(LoggerTests.class);

    @Test
    public void testLogger(){
        //打印不同级别的logger
        logger.debug("debug Log");
        logger.info("infor log");
        logger.warn("warn log");
        logger.error("error log");
    }
}
