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
public class Member {
    @Id
    private Long id;
    private String profile_img;
    private String profile_name;
    private String email;
    private String password;
    private LocalDateTime regDate;

}
