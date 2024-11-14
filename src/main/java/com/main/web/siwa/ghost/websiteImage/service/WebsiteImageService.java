package com.main.web.siwa.ghost.websiteImage.service;

import com.main.web.siwa.ghost.websiteImage.dto.WebsiteImageListDto;

import java.util.List;

public interface WebsiteImageService {
    List<WebsiteImageListDto> getList();
    List<WebsiteImageListDto> getById(Long id);
}
