package com.chenjiacheng.webapp.start.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenjiacheng on 2024/12/23 00:06
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@Component
public class ClockTask {

    @Scheduled(cron = "0 0 * * * ?")
    public void run() {
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
