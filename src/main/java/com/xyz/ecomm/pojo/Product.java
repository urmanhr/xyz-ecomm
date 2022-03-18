package com.xyz.ecomm.pojo;

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
@Table(name = "PRODUCT")
@Getter
@Setter
@EqualsAndHashCode()
@Builder
public class Product {

	@Id
	@Column(name = "PRODUCT_ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@Column(name = "CATEGORY_ID")
	private int categoryId;
	
	@Column(name = "SKU")
	private String sku;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "STOCK")
	private int stock;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "SIZE")
	private String size;
	
	@Column(name = "COLOR")
	private String color;
	
	@Column(name = "BRAND_ID")
	private int brandId;
	
	@Column(name = "SUPPLIER_ID")
	private int supplierId;
	
	@Column(name = "MARKET_REGION_ID")
	private int marketRegionId;
	
	@Column(name = "IS_ACTIVE")
	@Builder.Default
	private int isActive = 1;
}
