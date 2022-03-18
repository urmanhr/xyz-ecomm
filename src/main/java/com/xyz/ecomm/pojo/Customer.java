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
@Table(name = "CUSTOMER")
@Data
@NoArgsConstructor
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID", updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MARKET_REGION_ID")
	private int marketRegionId;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CONTACT_NO")
	private String contactNo;
}
