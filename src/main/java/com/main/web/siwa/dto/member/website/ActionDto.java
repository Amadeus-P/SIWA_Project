package com.main.web.siwa.usecase.member.website.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionDto {
    private Long memberId;
    private Long websiteId;
    private String action;
    private Boolean isAdded;
}
