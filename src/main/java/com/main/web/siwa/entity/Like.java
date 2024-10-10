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
public class Like {
    @Id
    private Long id;
    private Long websiteId;
    private Long memberId;
    private Long count;
    private Boolean isLike;
    private LocalDateTime regDate;

}
