package com.rockfly.dto;

import com.rockfly.models.Price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainStockDTO {

	private String itemName;

	private String itemCode;

	private String itemHsnSac;

	private String color;

	private String productType;

	// Size
	private String size;

	// Quantity
	private String quantity;
	
	private Price price;
}
