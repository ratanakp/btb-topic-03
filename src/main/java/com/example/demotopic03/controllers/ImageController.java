package com.example.demotopic03.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {


    @GetMapping("/add-image")
    public String showAddImageForm() {
        return "images/add-image";
    }





}
