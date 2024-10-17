package com.main.web.siwa.service;

import com.main.web.siwa.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {
    @Override
    public List<Category> getList() {


        return List.of();
    }
}
