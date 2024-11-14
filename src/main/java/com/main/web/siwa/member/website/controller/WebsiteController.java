package com.main.web.siwa.member.website.controller;

import com.main.web.siwa.entity.WebsiteImage;
import com.main.web.siwa.member.website.dto.WebsiteCreateDto;
import com.main.web.siwa.member.website.dto.WebsiteListDto;
import com.main.web.siwa.member.website.dto.WebsiteResponseDto;
import com.main.web.siwa.member.website.dto.WebsiteSearchDto;
import com.main.web.siwa.member.website.service.WebsiteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController("memberWebsiteController")
@RequestMapping("member/websites")
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
        WebsiteResponseDto responseDto = websiteService.getList(websiteSearchDto);
            return new ResponseEntity<>(responseDto, HttpStatus.OK); // 페이지 정보, 웹사이트 정보, 카테고리 정보
    }
    // GET + ID
    @GetMapping("/{wid}")
    public ResponseEntity<WebsiteListDto> getOne(
            @PathVariable(value = "wid", required = true) Long websiteId
    ) {
        return new ResponseEntity<>(websiteService.getById(websiteId),HttpStatus.OK);
    }

    @PostMapping("new")
    public ResponseEntity<?> create(
            @ModelAttribute WebsiteCreateDto websiteCreateDto,
            HttpServletRequest request,
            @RequestParam("img")List<MultipartFile> images
//            @RequestParam("memberId") Long memberId
    ) {
        try {
            websiteService.create(websiteCreateDto, images);
            return ResponseEntity.status(HttpStatus.CREATED).body("웹사이트 등록 성공");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("웹사이트 등록 중 오류가 발생했습니다.");
        }
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
