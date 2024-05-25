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
	
	private String item_Name;
	
	private String item_Code;
	
	private String item_HSN_SAC;
	
	private String color;
	
	private String product_type;
	
	
	//Size
	private String size;	
	
	//Quantity
	private String quantity;
	
	//Price
	private Long mrp;
	
	private Long sale_price;
	
	private Long wholesale_price;
	
	private Long purchase_price;
	
	/* private String tax_rate; */
}
