package com.main.web.siwa.usecase.member.website.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsiteSearchDto {
    private Integer page;
    private Integer size;
    private String keyWord;
    private Long categoryId;
}
