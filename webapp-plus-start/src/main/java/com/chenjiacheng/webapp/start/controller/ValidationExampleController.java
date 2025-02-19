package com.chenjiacheng.webapp.start.controller;

import com.chenjiacheng.webapp.start.controller.model.Result;
import com.chenjiacheng.webapp.start.controller.model.validation.ValidationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenjiacheng on 2025/2/17 22:54
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@RequestMapping("/validation")
@Controller
@Slf4j
public class ValidationExampleController {

    @RequestMapping(method = RequestMethod.POST, path = "/post")
    @ResponseBody
    public Result<String> post(@RequestBody @Validated ValidationRequest request) {
        log.info("request:{}",request);
        return Result.ofSuccess("success");
    }

}
