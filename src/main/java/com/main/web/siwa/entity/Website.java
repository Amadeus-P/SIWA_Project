package com.main.web.siwa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "website")
public class Website {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ColumnDefault("current_timestamp()")
    @Column(name = "reg_date", insertable = false, updatable = false)
    private Instant regDate;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "website")
    private List<Category> categories;

    @OneToMany(mappedBy = "website")
    @JsonManagedReference
    private List<WebsiteImage> images;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}