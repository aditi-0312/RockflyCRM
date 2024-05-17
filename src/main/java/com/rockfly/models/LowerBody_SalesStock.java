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
public class LowerBody_SalesStock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String item_name;
	
	private String item_code;
	
	private String item_HSN_SAC;
	
	private String color;
	
	private String category_name;
	
	private String product_type;
	
	private String size_28;
	
	private String size_30;
	
	private String size_32;
	
	private String size_34;
	
	private String size_36;
	
	private String size_38;
	
	private String size_40;
	
	private String exceptional_Size;
	
	@OneToOne()
	@JoinColumn(name = "price_id")
	private Price price;
}
