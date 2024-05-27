package com.rockfly.models;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	// Price
	private Long mrp;

	private Long salePrice;

	private Long wholesalePrice;

	private Long purchasePrice;

	/* private String tax_rate; */
	
	@OneToOne(mappedBy = "price")
	private MainStock shirtMainStock;
}
