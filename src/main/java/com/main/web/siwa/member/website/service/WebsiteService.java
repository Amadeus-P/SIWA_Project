package com.main.web.siwa.member.website.service;

import com.main.web.siwa.member.website.dto.WebsiteCreateDto;
import com.main.web.siwa.member.website.dto.WebsiteListDto;
import com.main.web.siwa.member.website.dto.WebsiteResponseDto;
import com.main.web.siwa.member.website.dto.WebsiteSearchDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WebsiteService {
    WebsiteResponseDto getList(Integer page, String title, Long categoryId);
    WebsiteResponseDto getList(WebsiteSearchDto websiteSearchDto);

    WebsiteListDto getById(Long id);
    WebsiteCreateDto create(WebsiteCreateDto websiteCreateDto, List<MultipartFile> images);
    WebsiteListDto update(WebsiteListDto websiteListDto);
    void delete(Long id);

}
