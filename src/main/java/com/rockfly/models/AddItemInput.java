package com.rockfly.models;

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
public class AddItemInput {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String productType;
	
	private String styleNumber;
	
	private String itemHsnSac;
	
	private String color;
	
	private String productSpecification;
	
	
	//Size
	private String size;	
	
	//Quantity
	private String quantity;
	
	//Price
	private Long mrp;
	
	private Long salePrice;
	
	private Long wholesalePrice;
	
	private Long purchasePrice;
	
	/* private String tax_rate; */
}
