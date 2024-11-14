package com.main.web.siwa.member.service;

import com.main.web.siwa.authentication.dto.SignupRequestDto;
import com.main.web.siwa.authentication.dto.SignupResponseDto;
import com.main.web.siwa.entity.Member;

public interface MemberService {
    SignupResponseDto create(SignupRequestDto requestDto);
}
