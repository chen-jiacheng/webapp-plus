package com.chenjiacheng.webapp.controller;

import com.chenjiacheng.webapp.common.annotation.RequireRoles;
import com.chenjiacheng.webapp.common.enums.WebappAuthEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenjiacheng on 2024/11/26 00:41
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @RequireRoles(WebappAuthEnum.ADMIN_PERMS)
    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestParam("username") String username){
        return ResponseEntity.ok("AdminController.get " + username);
    }

}