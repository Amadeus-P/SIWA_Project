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

    @Column(name = "username")
    private String username;
    
    // 이메일 인증 여부
    @Column(name = "email_verified")
    private Boolean emailVerified = false;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "profile_name")
    private String profileName;

    // 하위 테이블(자식 테이블)
    @OneToMany(mappedBy = "member")
    @JsonManagedReference
    private List<Website> websites;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberRole> memberRoles;

    // DB에 등록일이 제대로 삽이이 안되서 이거 씀
    @PrePersist
    protected void onCreate() {
        this.regDate = Instant.now(); // 현재 시간으로 등록일 설정
    }
}