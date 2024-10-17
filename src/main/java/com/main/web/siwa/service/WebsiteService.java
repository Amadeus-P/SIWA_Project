package com.main.web.siwa.service;

import com.main.web.siwa.dto.WebsiteDto;
import com.main.web.siwa.dto.WebsiteResponseDto;

import java.util.List;

public interface WebsiteService {
    WebsiteResponseDto getList(int page);
    WebsiteResponseDto getList(int page, String query);
    WebsiteDto getById(Long id);
    WebsiteDto create(WebsiteDto websiteDto);
    WebsiteDto update(WebsiteDto websiteDto);
    void delete(Long id);
}
