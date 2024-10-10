package com.main.web.siwa.controller;


import com.main.web.siwa.entity.Website;
import com.main.web.siwa.service.WebsiteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("controller")
@RequestMapping("/")
public class HomeController {

    private WebsiteService websiteRepository;

    public HomeController(WebsiteService websiteRepository){
        this.websiteRepository = websiteRepository;
    }

    @GetMapping("index")
    public List<Website> index() {
        return websiteRepository.getList();
    }
    @GetMapping("detail")
    public String detail() {
        return "detail";
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
