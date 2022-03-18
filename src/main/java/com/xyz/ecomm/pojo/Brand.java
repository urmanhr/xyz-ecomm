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
@Table(name = "BRAND")
@Getter
@Setter
@EqualsAndHashCode()
@Builder
public class Brand {
	
	@Id
	@Column(name = "BRAND_ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int brandId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "MARKET_REGION_IDS")
	private String marketRegionIds;

}
