package com.main.web.siwa.controller.member;

import com.main.web.siwa.entity.Website;
import com.main.web.siwa.service.WebsiteService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("memberController") // 페이지가 아니라 데이터를 전달
@RequestMapping("member")
public class HomeController {

    private WebsiteService websiteRepository;

    public HomeController(WebsiteService websiteRepository) {
        this.websiteRepository = websiteRepository;
    }

//    GET: 리소스를 조회합니다.
//    POST: 리소스를 생성합니다
//    PUT: 리소스를 교체합니다. > 기존 데이터를 삭제함
//    DELETE: 리소스를 삭제합니다.
//    PATCH: 리소스를 업데이트합니다. > 중복되는 데이터만 교체함
//    @GetMapping("index")
    @GetMapping(value = "index", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Website> index(
            @PathVariable(value = "id", required = true) Long id,
            @RequestHeader(value = "User-Agent") String userAgent
    ) {
        // 최신, 인기, 카테고리, 검색
        return websiteRepository.getList();
    }
    @GetMapping("detail")
    public String detail() {
        return "member/detail";
    }

    //    등록 페이지
//    @GetMapping("reg")
//    public String reg() {
//        return "reg";
//    }
//    @PostMapping("reg")
//    public String reg(
//            Model model
//    ) {
//        return "redirect:index";
//    }
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
