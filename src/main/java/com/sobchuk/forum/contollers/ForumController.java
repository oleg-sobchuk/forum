package com.sobchuk.forum.contollers;

import org.springframework.web.bind.annotation.GetMapping;

public class ForumController {

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }
}
