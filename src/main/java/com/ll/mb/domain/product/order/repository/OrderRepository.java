package com.ll.mb.domain.product.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ll.mb.domain.product.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
