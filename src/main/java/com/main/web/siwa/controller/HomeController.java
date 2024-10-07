package com.main.web.siwa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("controller")
@RequestMapping("/")
public class HomeController {

    @GetMapping("index")
    public String index() {
        return "index";
    }
    @GetMapping("detail")
    public String detail() {
        return "detail";
    }
    @GetMapping("reg")
    public String reg() {
        return "reg";
    }
    @GetMapping("report")
    public String report() {
        return "report";
    }
    @GetMapping("search")
    public String search() {
        return "search";
    }
    @GetMapping("share")
    public String share() {
        return "share";
    }
}
