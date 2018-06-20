package com.formation.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formation.entities.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
