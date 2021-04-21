package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/"})
public class TestController {

    @GetMapping({"/thhello"})
    public String thHello() {
        return "th/test";
    }

    @GetMapping({"/jsphello"})
    public String jspHello() {
        return "jsp/test";
    }

}
