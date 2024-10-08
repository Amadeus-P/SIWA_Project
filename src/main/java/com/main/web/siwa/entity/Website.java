package com.main.web.siwa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Website {

    @Id
    private Long id;
    private String name;
    private String url;
    private LocalDateTime regDate;
    private Long categoryId;
    private Long imgId;

}