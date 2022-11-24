package org.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class user {
    @GetMapping(value = "/name")
    public String UserName(){
        return "Name: shubhi";
    }

    @GetMapping(value = "gender")
    public String gender(){
        return "gender: female";
    }
}
