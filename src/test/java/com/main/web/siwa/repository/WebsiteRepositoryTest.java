package com.main.web.siwa.repository;

import com.main.web.siwa.dto.WebsiteDto;
import com.main.web.siwa.entity.Category;
import com.main.web.siwa.entity.Website;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class WebsiteRepositoryTest {

    @Autowired
    private WebsiteRepository websiteRepository;

    @Test
    void saveAllTest() {

    }
    @Test
    void queryTest() {

        Sort sort =
                Sort.by("id").descending();
        Pageable pageable =
                PageRequest.of(0, 20, sort);

        // 검색
//        List<Website> websites =
//                websiteRepository.findByQuery("%Exam%", pageable);
//        websites.forEach(System.out::println);
        // 인기순
    }
    @Test
    void findByIdTest() {
        Website website = new Website();
//        Optional<Website> websites =
//                websiteRepository.findById(website.getId());
    }
    @Test
    void findAllTest() {

        Sort sort =Sort.by("id").descending();
        Pageable pageable =
                PageRequest.of(0, 20, sort);

        // 웹사이트 다 주세요. > 목록 + 페이지와 정렬이 추가
        Page<Website> websitePage =
                websiteRepository.findAll(pageable);
        List<Website> websites = websitePage.getContent();

        // 다음 페이지
        while (websitePage.hasNext()){
            pageable = websitePage.nextPageable();
            websitePage = websiteRepository.findAll(pageable);
            websites = websitePage.getContent();
        }
        int page = pageable.getPageNumber(); // 현재 페이지
        int size = websitePage.getTotalPages(); // 전체 페이지

        System.out.println(websites);

    }
}