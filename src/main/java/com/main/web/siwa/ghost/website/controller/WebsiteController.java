package com.main.web.siwa.ghost.website.controller;

import com.main.web.siwa.ghost.website.dto.WebsiteListDto;
import com.main.web.siwa.ghost.website.dto.WebsiteResponseDto;
import com.main.web.siwa.ghost.website.dto.WebsiteSearchDto;
import com.main.web.siwa.ghost.website.service.WebsiteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController("websiteController")
    @RequestMapping("websites")
    public class WebsiteController {

        private WebsiteService websiteService;

        public WebsiteController(WebsiteService websiteService) {
            this.websiteService = websiteService;
        }

        // GET + 검색
        @GetMapping
        public ResponseEntity<WebsiteResponseDto> getList(
                @ModelAttribute WebsiteSearchDto websiteSearchDto
        ) {
            if(websiteSearchDto.getPage() == null || websiteSearchDto.getSize() < 1) {
                websiteSearchDto.setPage(1);
            }
            System.out.println("websiteSearchDto.getCategory()" + websiteSearchDto.getCategoryId());
            System.out.println("websiteSearchDto.getKeyWord()" + websiteSearchDto.getKeyWord());
            System.out.println("websiteSearchDto.getPage()" + websiteSearchDto.getPage());
            System.out.println("websiteSearchDto.getSize()" + websiteSearchDto.getSize());
            WebsiteResponseDto responseDto = websiteService.getList(websiteSearchDto);
            return new ResponseEntity<>(responseDto, HttpStatus.OK); // 페이지 정보, 웹사이트 정보, 카테고리 정보
        }
    // GET + ID + 추천 웹사이트
    @GetMapping("/{wid}")
    public ResponseEntity<WebsiteListDto> getOne(
            @PathVariable(value = "wid", required = true) Long websiteId
    ) {
        return new ResponseEntity<>(websiteService.getById(websiteId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WebsiteListDto> create(
            @RequestBody WebsiteListDto websiteListDto
    ) {
        return new ResponseEntity<>(websiteService.create(websiteListDto), HttpStatus.CREATED);
    }

    @PutMapping("{wid}")
    public ResponseEntity<WebsiteListDto> update(
            WebsiteListDto websiteListDto,
            @PathVariable(value = "wid", required = true) Long websiteId
    ) {
        websiteListDto.setId(websiteId);
        return new ResponseEntity<>(websiteService.update(websiteListDto), HttpStatus.OK);
    }
    
    // 웹 사이트 1개 삭제(무조건 wid로 개별 삭제할 것)
    @DeleteMapping("{wid}")
    public ResponseEntity<String> delete(
            @PathVariable(value = "wid", required = true) Long websiteId
    ) {
        websiteService.delete(websiteId);
        return new ResponseEntity<>("웹사이트가 삭제되었습니다.", HttpStatus.OK);
    }
}
