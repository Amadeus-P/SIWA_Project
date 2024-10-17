package com.main.web.siwa.repository;

import com.main.web.siwa.entity.WebsiteLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<WebsiteLike, Long> {
}
