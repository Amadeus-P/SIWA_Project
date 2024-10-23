package com.main.web.siwa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ColumnDefault("current_timestamp()")
    @Column(name = "reg_date")
    private Instant regDate;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "profile_name")
    private String profileName;

    // 하위 테이블(자식 테이블)
    @JsonManagedReference
    @OneToMany(mappedBy = "member")
    private List<Website> websites;

}