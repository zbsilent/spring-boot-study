package com.springstudy.autoconfig;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootStudyAtuoconfigApplicationTests {

    @Test
    void contextLoads() {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("基础信息");
        logger.warn("警告信息");
        logger.error("错误信息");

    }

}
