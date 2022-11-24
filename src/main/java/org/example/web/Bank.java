package org.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bank")
public class Bank {
    @GetMapping(value = "/account")
    public String accountDetails(){
        return "Account number:493848";
    }
    @GetMapping(value = "/password")
    public String pass(){
        return "Password:aksjc";
    }

}
