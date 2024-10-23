package com.main.web.siwa.repository;

import com.main.web.siwa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository {

    List<Category> findAllByCategoryId(Long categoryId);
}
