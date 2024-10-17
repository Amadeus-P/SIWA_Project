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
@Table(name = "not_recommend")
public class NotRecommend {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "is_not_recommended")
    private Boolean isNotRecommended;

    @Column(name = "count")
    private Long count;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "reg_date")
    private Instant regDate;

    @Column(name = "website_id")
    private Long websiteId;

}