package com.expmple.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private Logger logger = LogManager.getLogger(AppTest.class);

    /**
     * 日志文件备份测试 Test :-)
     */
    @Test
    public void log() {

        StringBuilder sb = new StringBuilder();
        int fileSize = 1024 * 1024 * 10;//文件大小，单位：byte
        for (int i = 0; i < fileSize; i++) {
            sb.append("1");
            if ((i + 1) % 1024 == 0) {
                logger.info(sb.toString());
                sb.delete(0,sb.length());
            }
        }

    }
}
