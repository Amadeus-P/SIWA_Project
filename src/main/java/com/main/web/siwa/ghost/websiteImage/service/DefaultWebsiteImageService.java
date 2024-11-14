package com.main.web.siwa.ghost.websiteImage.service;

import com.main.web.siwa.entity.Website;
import com.main.web.siwa.entity.WebsiteImage;
import com.main.web.siwa.ghost.websiteImage.dto.WebsiteImageListDto;
import com.main.web.siwa.repository.WebsiteImageRepository;
import com.main.web.siwa.repository.WebsiteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("websiteImageService")
public class DefaultWebsiteImageService implements WebsiteImageService {

    private WebsiteRepository websiteRepository;
    private WebsiteImageRepository websiteImageRepository;
    private ModelMapper modelMapper;

    public DefaultWebsiteImageService(
            WebsiteRepository websiteRepository,
            WebsiteImageRepository websiteImageRepository,
            ModelMapper modelMapper) {
        this.websiteRepository = websiteRepository;
        this.websiteImageRepository = websiteImageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<WebsiteImageListDto> getList() {
        List<WebsiteImage> images = websiteImageRepository.findAll();
        return images
                .stream()
                .map(websiteImage
                        -> modelMapper.map(websiteImage, WebsiteImageListDto.class))
                .toList();

    }

    @Override
    public List<WebsiteImageListDto> getById(Long websiteId) {
        // 웹사이트 먼저 가져오기
        Website website = websiteRepository.findById(websiteId)
                .orElseThrow(() -> new RuntimeException("웹사이트가 없는 것 같아요.."));

        // 그러면 웹사이트의 이미지 가져올 준비 끝
        List<WebsiteImage> images = websiteImageRepository.findAllByWebsite(website);

        return images
                .stream()
                .map((WebsiteImage websiteImage)
                        -> modelMapper
                        .map(websiteImage, WebsiteImageListDto.class))
                .toList();
    }
}
