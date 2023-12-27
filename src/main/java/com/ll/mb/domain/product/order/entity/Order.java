package com.ll.mb.domain.product.order.entity;

import static jakarta.persistence.CascadeType.*;
import static lombok.AccessLevel.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ll.mb.domain.member.member.entity.Member;
import com.ll.mb.domain.product.cart.entity.CartItem;
import com.ll.mb.global.jpa.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "order_")
public class Order extends BaseEntity {
	@ManyToOne
	private Member buyer;

	@Builder.Default
	@OneToMany(mappedBy = "order", cascade = ALL, orphanRemoval = true)
	private List<OrderItem> orderItems = new ArrayList<>();

	private LocalDateTime payDate; // 결제일
	private LocalDateTime cancelDate; // 취소일
	private LocalDateTime refundDate; // 환불일

	public void addItem(CartItem cartItem) {
		OrderItem orderItem = OrderItem.builder()
			.order(this)
			.product(cartItem.getProduct())
			.build();

		orderItems.add(orderItem);
	}

	public long calcPayPrice() {
		return orderItems.stream()
			.mapToLong(OrderItem::getPayPrice)
			.sum();
	}

	public void setPaymentDone() {
		payDate = LocalDateTime.now();
	}

	public void setCancelDone() {
		cancelDate = LocalDateTime.now();
	}

	public void setRefundDone() {
		refundDate = LocalDateTime.now();
	}
}