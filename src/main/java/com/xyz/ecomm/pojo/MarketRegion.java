package com.xyz.ecomm.pojo;

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
@Table(name = "MARKET_REGION")
@Data
@NoArgsConstructor
public class MarketRegion {
	
	@Id
	@Column(name = "MARKET_REGION_ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "REGION_NAME")
	private String name;
	
	@Column(name = "IS_ACTIVE")
	private int isActive;

}
