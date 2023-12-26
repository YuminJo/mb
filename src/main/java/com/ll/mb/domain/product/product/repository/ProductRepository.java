package com.ll.mb.domain.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ll.mb.domain.product.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}