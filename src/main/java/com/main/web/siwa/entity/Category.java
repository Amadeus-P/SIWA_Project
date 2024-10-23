package com.main.web.siwa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "name")
    private String name;

    // 하위 테이블(자식 테이블)
    @JsonManagedReference
    @OneToMany(mappedBy = "category")
    private List<Website> websites;

}