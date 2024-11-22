package com.main.web.siwa.member.comment.dto;

import com.main.web.siwa.member.website.dto.WebsiteListDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {

    private Long totalCount;
    private Long totalPages;
    private List<CommentListDto> commentListDtos;
    private List<Integer> pages;
}
