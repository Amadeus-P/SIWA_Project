package com.main.web.siwa.member.website.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InteractionDto {
    private Long memberId;
    private Long websiteId;
    private String action;
}
