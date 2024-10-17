package com.main.web.siwa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsiteResponseDto {

    private long websiteTotalCount;
    private List<WebsiteDto> websiteDtos;
}
