package com.xyz.ecomm.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCT")
@Data
@NoArgsConstructor
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private int isActive = 1;
	
	@ManyToOne
	@JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", insertable = false, updatable = false)
	private transient Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "SUPPLIER_ID", referencedColumnName = "SUPPLIER_ID", insertable = false, updatable = false)
	private transient Supplier supplier;
}
