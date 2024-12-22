package com.chenjiacheng.webapp.auth.controller;

import com.chenjiacheng.webapp.auth.common.annotation.RequireRoles;
import com.chenjiacheng.webapp.auth.common.enums.WebappAuthEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenjiacheng on 2024/11/26 00:41
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequireRoles({WebappAuthEnum.ADMIN_PERMS, WebappAuthEnum.USER_PERMS})
    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestParam("username") String username) {
        return ResponseEntity.ok("UserController.get " + username);
    }

}
