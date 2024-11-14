package com.main.web.siwa.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberUpdateDto {
    private Long id;
    private String email;
    private String profileImage;
    private String profileName;
    private Instant regDate;

}
