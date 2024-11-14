package com.main.web.siwa.member.website.dto;

import com.main.web.siwa.entity.Category;
import com.main.web.siwa.entity.WebsiteImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsiteCreateDto {
    private Long id;
    private String title;
    private String url;
    private Instant regDate;

    List<WebsiteImage> images;
    // 카테고리 정보
    private Category category;
}
