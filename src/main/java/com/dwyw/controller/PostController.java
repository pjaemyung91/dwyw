package com.dwyw.controller;

import com.dwyw.config.data.UserSession;
import com.dwyw.request.PostCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PostController {

    @PostMapping("/posts")
    public String post(@RequestBody PostCreate params, UserSession session) {
        log.info("params ={}", params.toString());
        log.info("session ={}", session);
        return "Hello World!";
    }
}
