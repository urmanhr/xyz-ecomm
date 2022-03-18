package com.xyz.ecomm.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT_CART")
@Data
@NoArgsConstructor
public class ProductCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CART_ID")
	private long cartId;
	
	@Column(name = "CUSTOMER_ID", updatable = false)
	private long customerId;
	
	@Column(name = "CART_DATE")
	private Timestamp cartDate;
	
	@Column(name = "MARKET_REGION_ID")
	private int marketRegionId;
	
	@Column(name = "PRODUCT_IDS")
	private String productIds;
}
