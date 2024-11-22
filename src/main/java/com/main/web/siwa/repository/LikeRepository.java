package com.main.web.siwa.repository;

import com.main.web.siwa.entity.Likes;
import com.main.web.siwa.entity.Member;
import com.main.web.siwa.entity.Website;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByWebsiteAndMember(Website website, Member member);
    boolean existsByWebsiteAndMember(Member member, Website website);
}
