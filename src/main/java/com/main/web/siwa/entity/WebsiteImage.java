package com.main.web.siwa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "website_image")
public class WebsiteImage {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "is_default")
    private Boolean isDefault;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "website_id")
    @JsonBackReference
    private Website website;

    @Column(name = "src")
    private String src;

}