package com.rockfly.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MainStock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String itemName;
	
	private String itemCode;
	
	private String itemHsnSac;
	
	private String color;
	
	private String productType;	
	
	//Size
	private String size;	
	
	//Quantity
	private String quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id")
	private Price price;
}
