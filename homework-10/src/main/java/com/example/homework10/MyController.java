package com.example.homework10;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/public/api")
    public String method1() {
        return "hello";
    }

    @GetMapping("/admin/api")
    public User method2(Authentication authentication) {
        return new User(authentication.getName(), authentication.getAuthorities().toString());
    }

    @GetMapping("/support/api")
    public User method3(Authentication authentication) {
        return new User(authentication.getName(), authentication.getAuthorities().toString());
    }
}

