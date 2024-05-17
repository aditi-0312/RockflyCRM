package com.rockfly.models;

import jakarta.persistence.CascadeType;
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
public class Price {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long mrp;
	
	private Long sale_price;
	
	private Long wholesale_price;
	
	private Long purchase_price;
	
	@OneToOne(mappedBy = "price")
	private LowerBody_MainStock lowerBody_MainStock;
	
	@OneToOne(mappedBy = "price")
	private LowerBody_SalesStock lowerBody_SalesStock;
	
	
	}
