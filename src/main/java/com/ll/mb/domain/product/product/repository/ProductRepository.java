package com.ll.mb.domain.product.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ll.mb.domain.book.book.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
