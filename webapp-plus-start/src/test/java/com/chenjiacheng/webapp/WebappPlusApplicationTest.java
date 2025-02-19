package com.chenjiacheng.webapp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

/**
 * Created by chenjiacheng on 2024/11/26 00:03
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@SpringBootTest
class WebappPlusApplicationTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void contextLoader() {
        log.info("ctx:{}", ctx);
        Assert.notNull(ctx, "ApplicationContext can't be null.");
    }
}