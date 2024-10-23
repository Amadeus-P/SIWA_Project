package com.main.web.siwa.member.website.service;

import com.main.web.siwa.member.website.dto.WebsiteDto;
import com.main.web.siwa.member.website.dto.WebsiteResponseDto;

public interface WebsiteService {
    WebsiteResponseDto getList(int page);
    WebsiteResponseDto getList(int page, String query);
    WebsiteResponseDto getList(int page, Long categoryId);

    WebsiteDto getById(Long id);
    WebsiteDto create(WebsiteDto websiteDto);
    WebsiteDto update(WebsiteDto websiteDto);
    void delete(Long id);

}
