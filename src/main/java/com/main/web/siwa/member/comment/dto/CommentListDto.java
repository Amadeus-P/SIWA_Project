package com.main.web.siwa.member.comment.dto;

import com.main.web.siwa.member.dto.MemberListDto;
import com.main.web.siwa.member.website.dto.WebsiteListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentListDto {

    private Long id;
    private String content;
    private Instant regDate;

    private Long memberId;
    private Long websiteId;

}
