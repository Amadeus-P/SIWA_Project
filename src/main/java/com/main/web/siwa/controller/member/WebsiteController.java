package com.main.web.siwa.controller.member;

import com.main.web.siwa.dto.WebsiteDto;
import com.main.web.siwa.dto.WebsiteResponseDto;
import com.main.web.siwa.service.WebsiteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/websites")
public class WebsiteController {

    private WebsiteService websiteService;

    public WebsiteController(WebsiteService websiteService) {
        this.websiteService = websiteService;
    }

    // GET
    @GetMapping
    public ResponseEntity<WebsiteResponseDto> getList(
            // 페이징 page: 요청 페이지 , size: 한 페이지 당 웹페이지 개수
            @RequestParam(name = "p", defaultValue = "1")int  page
    ) {
        return new ResponseEntity<>(websiteService.getList(page), HttpStatus.OK); // 페이지 정보, 웹사이트 정보, 카테고리 정보
    }
    // GET + 검색
    @GetMapping("/query")
    public ResponseEntity<WebsiteResponseDto> getList(
            @RequestParam(name = "p", defaultValue = "1")int  page,
            @RequestParam(name = "q")String query
    ) {
        return new ResponseEntity<>(websiteService.getList(page, query), HttpStatus.OK); // 페이지 정보, 웹사이트 정보, 카테고리 정보
    }
    // GET + ID + 추천 웹사이트
    @GetMapping("{wid}")
    public ResponseEntity<WebsiteDto> getOne(
            @PathVariable(value = "wid", required = true) Long id
    ) {
        return new ResponseEntity<>(websiteService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WebsiteDto> create(
            @RequestBody WebsiteDto websiteDto
    ) {
        return new ResponseEntity<>(websiteService.create(websiteDto), HttpStatus.CREATED);
    }

    @PutMapping("{wid}")
    public ResponseEntity<WebsiteDto> update(
            WebsiteDto websiteDto,
            @PathVariable(value = "wid", required = true) Long id
    ) {
        return new ResponseEntity<>(websiteDto, HttpStatus.OK);
    }
    
    // 웹 사이트 1개 삭제(무조건 wid로 개별 삭제할 것)
    @DeleteMapping("{wid}")
    public ResponseEntity<String> delete(
            @PathVariable(value = "wid", required = true) Long id
    ) {
        websiteService.delete(id);
        return new ResponseEntity<>("웹사이트가 삭제되었습니다.", HttpStatus.OK);
    }
}
