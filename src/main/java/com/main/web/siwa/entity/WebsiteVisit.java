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
@Table(name = "website_visit")
public class WebsiteVisit {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "count")
    private Long count;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "time")
    private Instant time;

    @Column(name = "website_id")
    private Long websiteId;

}