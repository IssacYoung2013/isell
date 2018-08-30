package com.issac;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * author:  ywy
 * date:  2018-08-29
 * desc:
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1() {
        log.info("info...");
        log.debug("debug...");
        log.error("error...");
        log.warn("warn...");
    }
}