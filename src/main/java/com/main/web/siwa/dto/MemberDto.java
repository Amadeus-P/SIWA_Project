package com.main.web.siwa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private Long id;
    private String profile_img;
    private String profile_name;
    private String email;
    private String password;
    private LocalDateTime regDate;

    private Boolean isLiked;
    private Boolean isRecommended;
    private Boolean isNotRecommended;
}
