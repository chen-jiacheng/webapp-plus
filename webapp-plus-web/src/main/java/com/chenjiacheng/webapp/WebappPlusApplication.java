package com.chenjiacheng.webapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by chenjiacheng on 2024/11/25 23:53
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@EnableScheduling
@SpringBootApplication
public class WebappPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappPlusApplication.class, args);
        log.info("--- 服务启动成功 ---");
    }
}