package com.main.web.siwa.ghost.website.service;

import com.main.web.siwa.ghost.website.dto.WebsiteListDto;
import com.main.web.siwa.ghost.website.dto.WebsiteResponseDto;
import com.main.web.siwa.ghost.website.dto.WebsiteSearchDto;

public interface WebsiteService {
    WebsiteResponseDto getList(Integer page, String title, Long categoryId);
    WebsiteResponseDto getList(WebsiteSearchDto websiteSearchDto);

    WebsiteListDto getById(Long id);

}
