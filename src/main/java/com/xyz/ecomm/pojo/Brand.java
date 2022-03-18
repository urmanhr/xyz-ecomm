package com.xyz.ecomm.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BRAND")
@Data
@NoArgsConstructor
public class Brand implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BRAND_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int brandId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "MARKET_REGION_IDS")
	private String marketRegionIds;

}
