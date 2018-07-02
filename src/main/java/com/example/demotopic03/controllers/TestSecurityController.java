package com.example.demotopic03.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestSecurityController {


    @GetMapping("/user")
    public String showUser() {
        return "test-security/user";
    }


    @GetMapping("/dba")
    public String showDBA() {
        return "test-security/dba";
    }


    @GetMapping("/admin")
    public String showAdmin() {
        return "test-security/admin";
    }



}
