package com.xyz.ecomm.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDER")
@Getter
@Setter
@EqualsAndHashCode()
@Builder
public class Order {
	
	@Id
	@Column(name = "ORDER_ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@Column(name = "CUSTOMER_ID", updatable = false)
	private long customerId;
	
	@Column(name = "CART_ID")
	private long cartId;
	
	@Column(name = "ORDER_DATE")
	private Timestamp orderDate;
	
	@Column(name = "IS_COMPLETED")
	private int isCompleted;

}
