package com.chenjiacheng.webapp.startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by chenjiacheng on 2024/12/19 01:02
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@Component
public class ApplicationStartup implements ApplicationRunner {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationContext:{}", ctx);
    }
}
