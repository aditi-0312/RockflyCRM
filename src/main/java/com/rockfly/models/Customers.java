package com.rockfly.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
	
	private String shopName;
	
	private String partyName;
	
	private String contactPerson;
	
	private String email;
	
	private String city;
	
	private String state;
	
	private String phone;
	
	private  String address;
	
	private String pincode;
	
	private String documentNumber;
	
	private Long openingBalance;
	
	private LocalDate asOfDate;
	
	private Long creditLimit;
	
	@OneToOne
	private DocumentType documentType;
	
	
}
