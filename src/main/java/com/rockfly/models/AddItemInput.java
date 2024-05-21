package com.rockfly.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
	private String opening_Stock;
	
	private String minStockToMaintain;
	
	
	//Size
	private String size_28;
	
	private String size_30;
	
	private String size_32;
	
	private String size_34;
	
	private String size_36;
	
	private String size_38;
	
	private String size_40;
	
	private String size_42;
	
	private String size_44;
	
	private String size_46;
	
	private String size_48;
	
	private String size_50;
	
	//Alpha Numeric
	private String size_XS_30_32;
	
	private String size_S_34_36;
	
	private String size_M_38_40;
	
	private String size_L_42_44;
	
	private String size_XL_46_48;
	
	private String size_2XL_50_52;
	
	private String size_3XL_54_56;
	
	private String size_4XL_58_60;
	
	private String size_5XL_62_64;
	
	private String size_6XL_66_68;
	
	private String size_7XL_70_72;
	
	private String size_8XL_74_76;
	
	
	
	//Price
	private Long mrp;
	
	private Long sale_price;
	
	private Long wholesale_price;
	
	private Long purchase_price;
	
	private Long tax_rate;
}
