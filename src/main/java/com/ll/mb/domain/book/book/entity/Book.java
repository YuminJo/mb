package com.ll.mb.domain.book.book.entity;
import static lombok.AccessLevel.*;

import com.ll.mb.domain.member.member.entity.Member;
import com.ll.mb.global.jpa.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class Book extends BaseEntity {
	@ManyToOne
	private Member author;
	private String title;
	private String body;
	private int price;
}