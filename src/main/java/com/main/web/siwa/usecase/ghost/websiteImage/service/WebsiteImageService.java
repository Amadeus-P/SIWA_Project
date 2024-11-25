package com.main.web.siwa.ghost.websiteImage.service;

import com.main.web.siwa.ghost.websiteImage.dto.WebsiteImageCreateDto;
import com.main.web.siwa.ghost.websiteImage.dto.WebsiteImageListDto;
import com.main.web.siwa.member.website.dto.WebsiteCreateDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WebsiteImageService {
    List<WebsiteImageListDto> getList();
    List<WebsiteImageListDto> getById(Long id);
    WebsiteImageCreateDto create(List<MultipartFile> images);
}
