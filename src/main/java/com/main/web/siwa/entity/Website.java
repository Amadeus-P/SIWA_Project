package com.main.web.siwa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @ColumnDefault("current_timestamp()")
    @Column(name = "reg_date")
    private Instant regDate;

    // 상위 테이블(부모 테이블)
    @JsonManagedReference
    @OneToMany(mappedBy = "website")
    private List<WebsiteImage> images;

    // 하위 테이블(자식 테이블)
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "member_id")
    private Member member;

}