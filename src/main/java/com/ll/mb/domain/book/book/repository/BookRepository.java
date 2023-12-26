package com.ll.mb.domain.book.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ll.mb.domain.book.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}