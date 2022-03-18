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
@Table(name = "SUPPLIER")
@Getter
@Setter
@EqualsAndHashCode()
@Builder
public class Supplier {
	
	@Id
	@Column(name = "SUPPLIER_ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplierId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MARKET_REGION_IDS")
	private String marketRegionIds;
	
	

}
