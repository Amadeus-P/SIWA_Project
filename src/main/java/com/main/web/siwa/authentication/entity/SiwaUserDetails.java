package com.main.web.siwa.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiwaUserDetails implements UserDetails {

    // 인증 시 추가로 필요할 수도 있는 정보
    private Long id;
    private String profileName;
    private String profileImage;

    // 인증 시 필수 정보
    private String username; // 이메일
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
}
