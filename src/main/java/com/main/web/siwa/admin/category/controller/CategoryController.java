package com.main.web.siwa.admin.category.controller;

import com.main.web.siwa.admin.category.dto.CategoryListDto;
import com.main.web.siwa.admin.category.dto.CategoryResponseDto;
import com.main.web.siwa.admin.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("categoryController")
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<CategoryResponseDto> getMainCategoryList(
            @RequestParam(value = "parentId", required = false) Long parentId
    ) {
        CategoryResponseDto responseDto = categoryService.getList(parentId);
        System.out.println("responseDto: " + responseDto);
        System.out.println("parentId: " + parentId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
