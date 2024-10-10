package com.main.web.siwa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Search {
    @Id
    private Long id;
    private Long websiteId;
    private Long memberId;
    private Long categoryId;
    private String keyword;
    private LocalDateTime regDate;
}
