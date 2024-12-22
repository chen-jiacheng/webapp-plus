package com.chenjiacheng.webapp.auth.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * Created by chenjiacheng on 2024/11/25 23:59
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Data
@Configuration
public class WebappAuthConfig {

    @Value("#{${rids:{'USER':'H000001','ADMIN':'H000002'}}}")
    private Map<String, String> rids;

}
