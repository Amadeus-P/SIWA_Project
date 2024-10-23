package com.main.web.siwa.member.website.service;

import com.main.web.siwa.member.website.dto.WebsiteDto;
import com.main.web.siwa.member.website.dto.WebsiteResponseDto;
import com.main.web.siwa.entity.Website;
import com.main.web.siwa.member.website.mapper.WebsiteMapper;
import com.main.web.siwa.repository.WebsiteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultWebsiteService implements WebsiteService {

    private WebsiteRepository websiteRepository;

    public DefaultWebsiteService(WebsiteRepository websiteRepository){
        this.websiteRepository = websiteRepository;
    }
    // GET
    @Override
    public WebsiteResponseDto getList(int page) {
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(page-1, 20, sort); // 0
        Page<Website> websitePage = websiteRepository.findAll(pageable);

        // Entity를 DTO로 바꾸기 > Stream
        List<WebsiteDto> websiteDtos = websitePage
                .getContent()
                .stream()
                .map(WebsiteMapper::mapToDto)
                .toList();

        // 조회된 모든 웹사이트 갯수
        long websiteTotalCount = websitePage.getTotalElements();

        return WebsiteResponseDto
                .builder()
                .websiteDtos(websiteDtos)
                .websiteTotalCount(websiteTotalCount)
                .build();
    }
    // GET + 검색
    @Override
    public WebsiteResponseDto getList(int page, String query) {
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(page-1, 20, sort); // 0
        Page<Website> websitePage = websiteRepository.findAll(query, pageable);

        // Entity를 DTO로 바꾸기 > Stream
        List<WebsiteDto> websiteDtos = websitePage
                .getContent()
                .stream()
                .map(WebsiteMapper::mapToDto)
                .toList();
        long websiteTotalCount = websitePage.getTotalElements();

        // 다음 페이지
//        while (websitePage.hasNext()){
//            pageable = websitePage.nextPageable();
//            websitePage = websiteRepository.findAll(pageable);
//        }
//        page = pageable.getPageNumber(); // 현재 페이지
//        int size = websitePage.getTotalPages(); // 전체 페이지

        return WebsiteResponseDto
                .builder()
                .websiteDtos(websiteDtos)
                .websiteTotalCount(websiteTotalCount)
                .build();
    }

    @Override
    public WebsiteResponseDto getList(int page, Long categoryId) {
        Sort sort = Sort.by("regDate").descending();
        Pageable pageable = PageRequest.of(page-1, 20, sort); // 0
        Page<Website> websitePage = websiteRepository.findAllByCategoryId(categoryId, pageable);

        List<WebsiteDto> websiteDtos = websitePage
                .getContent()
                .stream()
                .map(WebsiteMapper::mapToDto)
                .toList();
        long websiteTotalCount = websitePage.getTotalElements();

        return WebsiteResponseDto
                .builder()
                .websiteDtos(websiteDtos)
                .websiteTotalCount(websiteTotalCount)
                .build();
    }
    // GET + id
    @Override
    public WebsiteDto getById(Long id) {
       Website website =  websiteRepository
               .findById(id)
               .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + id));
        return WebsiteMapper.mapToDto(website);
    }
    // POST
    @Override
    @Transactional
    public WebsiteDto create(WebsiteDto websiteDto) {
        // 중복검사
//        Website website = websiteRepository.findById(websiteDto.getId()).orElseThrow();
//        if(websiteDto.getUrl().equals(website));

        Website website = websiteRepository.save(WebsiteMapper.mapToEntity(websiteDto));
        return WebsiteMapper.mapToDto(website);
    }
    // PUT
    @Override
    public WebsiteDto update(WebsiteDto websiteDto) {
        // 1. JPA SQL Method
        // 업데이트는 기존에 존재하는 테이블에만 데이터를 저장할 수 있게
        // 테이블 id가 있는지 확인하는 과정을 넣는다.
        Website website = websiteRepository
                .findById(websiteDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + websiteDto.getId()));

        // 일괄 업데이트가 아닌 부분 업데이트 로직을 구현함
//        if(websiteDto.getName() != null)
//            website.setName(websiteDto.getName());
//        if(websiteDto.getImages() != null)
//            website.setImages(websiteDto.getImages());
//        if(websiteDto.getCategorIds() != null)
//            website.setCategoryIds(websiteDto.getCategorIds());
//        if(websiteDto.getImages() != null)
//            website.setImages(websiteDto.getImages());

        // JPA가 알아서 save()하긴 하는데
        websiteRepository.save(website);

        // 혹시 모르니까 저장 후에도 id 확인
        Website updateWebsite = websiteRepository
                .findById(websiteDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + websiteDto.getId()));

        return WebsiteMapper.mapToDto(updateWebsite);
    }
    // DELETE
    @Override
    public void delete(Long id) {
        websiteRepository.deleteById(id);
    }

}
