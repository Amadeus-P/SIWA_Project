package com.main.web.siwa.repository;

import com.main.web.siwa.entity.WebsiteImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgRepository extends JpaRepository<WebsiteImage, Long> {
}
