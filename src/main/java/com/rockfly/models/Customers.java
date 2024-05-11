package com.rockfly.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customers {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String email;
	
	private String city;
	
	private String state;
	
	private String phone;
	
	private  String billingAddress;
	
	private  String shippingAddress;
	
	private String documentType;
	
	private String documentNumber;
	
	private Long openingBalance;
	
	private LocalDate asOfDate;
	
	private Long creditLimit;
	
}
