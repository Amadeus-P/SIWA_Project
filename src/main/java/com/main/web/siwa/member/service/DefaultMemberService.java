package com.main.web.siwa.member.service;

import com.main.web.siwa.authentication.dto.SignupRequestDto;
import com.main.web.siwa.authentication.dto.SignupResponseDto;
import com.main.web.siwa.entity.Member;
import com.main.web.siwa.entity.MemberRole;
import com.main.web.siwa.entity.Role;
import com.main.web.siwa.entity.Website;
import com.main.web.siwa.member.dto.MemberListDto;
import com.main.web.siwa.member.dto.MemberResponseDto;
import com.main.web.siwa.member.dto.MemberSearchDto;
import com.main.web.siwa.member.website.dto.WebsiteListDto;
import com.main.web.siwa.repository.MemberRepository;
import com.main.web.siwa.repository.MemberRoleRepository;
import com.main.web.siwa.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultMemberService implements MemberService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final MemberRoleRepository memberRoleRepository;

    public DefaultMemberService(MemberRepository memberRepository,
                                RoleRepository roleRepository,
                                ModelMapper modelMapper,
                                PasswordEncoder passwordEncoder, MemberRoleRepository memberRoleRepository) {
        this.memberRepository = memberRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.memberRoleRepository = memberRoleRepository;
    }


    @Override
    public MemberResponseDto getList(MemberSearchDto memberSearchDto) {
        return null;
    }

    @Override
    public MemberListDto getById(Long memberId) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다. id = " + memberId));
        return modelMapper.map(member, MemberListDto.class);
    }

    @Override
    public SignupResponseDto create(SignupRequestDto requestDto) {
        // 중복 검사
        if(memberRepository.findByUsername(requestDto.getUsername()) != null)
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");

        // 비번 암호화
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        requestDto.setPassword(encodedPassword);

        Member createdMember = memberRepository.save(modelMapper.map(requestDto, Member.class));

        // 회원, 관리자
        Role role = roleRepository.findByName("ROLE_MEMBER");
        if (role == null) {
            throw new IllegalArgumentException("기본 역할을 찾을 수 없습니다.");
        }
        MemberRole memberRole = new MemberRole();
        memberRole.setMember(createdMember);
        memberRole.setRole(role);

        memberRoleRepository.save(memberRole);

        SignupResponseDto responseDto = SignupResponseDto.builder()
                .id(createdMember.getId())
                .username(createdMember.getUsername())
                .profileName(createdMember.getProfileName())
                .profileImage(createdMember.getProfileImage())
                .build();
        return responseDto;
    }

    @Override
    public MemberListDto update(MemberListDto memberListDto) {
        Member member = memberRepository
                .findById(memberListDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + memberListDto.getId()));

        // 일괄 업데이트가 아닌 부분 업데이트 로직을 구현함
        if(memberListDto.getUsername() != null)
            member.setUsername(memberListDto.getUsername());
        if(memberListDto.getProfileImage() != null)
            member.setProfileImage(memberListDto.getProfileImage());
        if(memberListDto.getProfileName() != null)
            member.setProfileName(memberListDto.getProfileName());
        if(memberListDto.getPassword() != null)
            member.setPassword(memberListDto.getPassword());

        memberRepository.save(member);

        // 업데이트 된 웹사이트 가져오기
        Member updateMember = memberRepository
                .findById(memberListDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 웹사이트입니다. id = " + memberListDto.getId()));

        return modelMapper.map(updateMember, MemberListDto.class);
    }

    @Override
    public void delete(Long memberId) {
        memberRepository.deleteById(memberId);
    }




}
