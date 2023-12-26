package com.ll.mb.global.initData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import com.ll.mb.domain.book.book.entity.Book;
import com.ll.mb.domain.book.book.service.BookService;
import com.ll.mb.domain.cash.cash.entity.CashLog;
import com.ll.mb.domain.member.member.entity.Member;
import com.ll.mb.domain.member.member.service.MemberService;
import com.ll.mb.domain.product.cart.service.CartService;
import com.ll.mb.domain.product.product.entity.Product;
import com.ll.mb.domain.product.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class NotProd {
	@Autowired
	@Lazy
	private NotProd self;
	private final MemberService memberService;
	private final BookService bookService;
	private final ProductService productService;
	private final CartService cartService;

	@Bean
	public ApplicationRunner initNotProd() {
		return args -> {
			self.work1();
		};
	}

	@Transactional
	public void work1() {
		Member memberAdmin = memberService.join("admin", "1234").getData();
		Member memberUser1 = memberService.join("user1", "1234").getData();
		Member memberUser2 = memberService.join("user2", "1234").getData();
		Member memberUser3 = memberService.join("user3", "1234").getData();

		Book book1 = bookService.createBook(memberUser1, "책 제목 1", "책 내용 1", 10_000);
		Book book2 = bookService.createBook(memberUser2, "책 제목 2", "책 내용 2", 12_000);
		Book book3 = bookService.createBook(memberUser3, "책 제목 3", "책 내용 3", 13_000);
		Book book4 = bookService.createBook(memberUser1, "책 제목 4", "책 내용 4", 14_000);
		Book book5 = bookService.createBook(memberUser2, "책 제목 5", "책 내용 5", 15_000);
		Book book6 = bookService.createBook(memberUser3, "책 제목 6", "책 내용 6", 16_000);

		Product product1 = productService.createProduct(book3);
		Product product2 = productService.createProduct(book4);
		Product product3 = productService.createProduct(book5);

		cartService.addItem(memberUser1, product1);
		cartService.addItem(memberUser1, product2);
		cartService.addItem(memberUser1, product3);

		memberService.addCash(memberUser1, 100_000, CashLog.EvenType.충전__무통장입금, memberUser1);
	}
}
