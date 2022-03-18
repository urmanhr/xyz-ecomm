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
@Table(name = "CATEGORY")
@Getter
@Setter
@EqualsAndHashCode()
@Builder
public class Category {
	
	@Id
	@Column(name = "CATEGORY_ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MARKET_REGION_IDS")
	private String marketRegionIds;
	
	@Column(name = "IS_ACTIVE")
	private int isActive;

}
