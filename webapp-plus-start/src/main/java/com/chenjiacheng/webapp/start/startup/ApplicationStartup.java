package com.chenjiacheng.webapp.start.startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private ThreadPoolTaskExecutor customExecutor;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationContext:{}", ctx);

        // customExecutor.execute(this::clock);
    }

    private void clock() {
        while (true) {
            log.info("Current time:{}", LocalDateTime.now());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                log.error("Thread sleep error", e);
            }
        }
    }
}
