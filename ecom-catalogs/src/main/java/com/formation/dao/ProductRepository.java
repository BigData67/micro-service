package com.formation.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.formation.entities.Product;


public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
