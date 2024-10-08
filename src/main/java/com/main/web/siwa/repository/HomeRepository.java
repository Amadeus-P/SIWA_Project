package com.main.web.siwa.repository;

import com.main.web.siwa.entity.Website;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Website, Long> {

}
