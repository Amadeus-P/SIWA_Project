package com.main.web.siwa.admin.member.controller;

import com.main.web.siwa.admin.member.dto.MemberDto;
import com.main.web.siwa.entity.Member;
import com.main.web.siwa.repository.MemberRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public List<Member> getList(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "1") int size
    ) {
        return memberRepository.findAll();
    }

    @GetMapping("{mid}")
    public Member get(
            @PathVariable(value = "mid", required = true) Long id
    ) {
        return null;
    }
    @PostMapping
    public ResponseEntity<MemberDto> reg() {

        return null;
    }
    @PutMapping
    public ResponseEntity<MemberDto> update() {

        return null;
    }
    @DeleteMapping
    public ResponseEntity<MemberDto> delete() {

        return null;
    }



}
