package com.chenjiacheng.webapp.start.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Properties;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by chenjiacheng on 2024/12/22 21:57
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@RequestMapping("/")
@RestController
public class WebappPlusApplicationController {

    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            Resource resource = new ClassPathResource("git.properties");
            properties.load(resource.getURL().openStream());
        } catch (IOException e) {
            log.warn("git.properties not found");
        }
    }

    @RequestMapping(method = GET)
    public String index() {
        return properties.toString();
    }

}
