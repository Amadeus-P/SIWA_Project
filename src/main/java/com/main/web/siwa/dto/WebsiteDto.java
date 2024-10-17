package com.main.web.siwa.dto;

import com.main.web.siwa.entity.Category;
import com.main.web.siwa.entity.WebsiteImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsiteDto {

    // REST API를 통해 전달할 데이터, DTO(Model)
    
    private Long id;
    private String name;
    private String url;
    private Instant regDate;
//    private Long categoryId;
//    private Long imageId;
    
//    // 카테고리, 이미지
//    private List<Category> categoryNames;
    private List<WebsiteImage> images;
//    private String defaultImage;
//
//    // 좋아요, 추천, 비추천
//    private Boolean isLiked;
//    private Boolean isRecommended;
//    private Boolean isNotRecommended;
//
//    private Long likeCount;
//    private Long recommendCount;
//    private Long notRecommendCount;
//
//
//    // 로그(검색, 조회, 방문)
//    private Long searchFrequency;
//    private Long viewCount;
//    private Long visitCount;
//
//    private LocalDateTime searchTime;
//    private LocalDateTime viewTime;
//    private LocalDateTime visitTime;


}
