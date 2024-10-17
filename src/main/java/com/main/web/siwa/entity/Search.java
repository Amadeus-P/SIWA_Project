package com.main.web.siwa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "search")
public class Search {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "frequency")
    private Long frequency;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "time")
    private Instant time;

    @Column(name = "website_id")
    private Long websiteId;

    @Column(name = "keyword")
    private String keyword;

}