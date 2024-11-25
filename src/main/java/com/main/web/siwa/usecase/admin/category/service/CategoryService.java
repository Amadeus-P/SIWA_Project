package com.main.web.siwa.admin.category.service;

import com.main.web.siwa.admin.category.dto.CategoryResponseDto;

public interface CategoryService {
    CategoryResponseDto getList(Long parentId);

}
