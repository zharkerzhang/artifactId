package com.zharker.artifactId.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    String home(){
        return "hello";
    }


    @RequestMapping("/userInfo")
    Object userInfo(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
