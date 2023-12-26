package com.ll.mb.domain.cash.cash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ll.mb.domain.cash.cash.entity.CashLog;

@Repository
public interface CashLogRepository extends JpaRepository<CashLog, Long> {
}
