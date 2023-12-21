package com.ll.mb.domain.book.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ll.mb.domain.book.book.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
