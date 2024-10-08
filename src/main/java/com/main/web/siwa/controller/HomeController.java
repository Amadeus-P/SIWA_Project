package com.main.web.siwa.controller;


import com.main.web.siwa.entity.Website;
import com.main.web.siwa.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("controller")
@RequestMapping("/")
public class HomeController {

    private HomeService homeService;

    public HomeController(HomeService homeService){
        this.homeService = homeService;
    }

    @GetMapping("index")
    public List<Website> index() {
        return homeService.getList();
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
