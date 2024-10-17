package com.main.web.siwa.mapper;

import com.main.web.siwa.dto.WebsiteDto;
import com.main.web.siwa.entity.Website;

public class WebsiteMapper {
    // Entity와 DTO처럼 타입이 다른 데이터를 저장하기 위해
    // Entity-DB : DTO-Model > View에서 DB까지 데이터를 전달하려면
    // 타입이 다른 객체(같은 속성을 가짐)의 속성에 직접 데이터를 저장하는 방식

    public static WebsiteDto mapToDto(Website website) {
        if(website == null)
            return null;
        // 화면 데이터 전달
        return WebsiteDto
                .builder()
                .id(website.getId())
                .name(website.getName())
                .url(website.getUrl())
                .regDate(website.getRegDate())
                .build();
//                .categoryId(website.getCategories())
    }
    public static Website mapToEntity(WebsiteDto websiteDto) {
        if(websiteDto == null)
            return null;
        // Entity-DB에 데이터 입력
        return Website
                .builder()
                .id(websiteDto.getId())
                .name(websiteDto.getName())
                .url(websiteDto.getUrl())
                .regDate(websiteDto.getRegDate())
                .build();
    }

}
