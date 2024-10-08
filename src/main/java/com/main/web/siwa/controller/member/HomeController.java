package com.main.web.siwa.controller.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("memberController")
@RequestMapping("member")
public class HomeController {

    @GetMapping("index")
    public String index() {
        return "member/index";
    }
    @GetMapping("detail")
    public String detail() {
        return "member/detail";
    }
    @GetMapping("reg")
    public String reg() {
        return "member/reg";
    }
    @GetMapping("report")
    public String report() {
        return "member/report";
    }
    @GetMapping("search")
    public String search() {
        return "member/search";
    }
    @GetMapping("share")
    public String share() {
        return "member/share";
    }

}
