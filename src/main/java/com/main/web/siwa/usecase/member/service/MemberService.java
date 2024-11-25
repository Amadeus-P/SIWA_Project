package com.main.web.siwa.member.service;

import com.main.web.siwa.authentication.dto.SignupRequestDto;
import com.main.web.siwa.authentication.dto.SignupResponseDto;
import com.main.web.siwa.entity.Member;
import com.main.web.siwa.member.dto.MemberListDto;
import com.main.web.siwa.member.dto.MemberResponseDto;
import com.main.web.siwa.member.dto.MemberSearchDto;

public interface MemberService {
    SignupResponseDto create(SignupRequestDto requestDto);

    MemberListDto getById(Long memberId);

    MemberResponseDto getList(MemberSearchDto memberSearchDto);

    void delete(Long memberId);

    MemberListDto update(MemberListDto memberListDto);
}
