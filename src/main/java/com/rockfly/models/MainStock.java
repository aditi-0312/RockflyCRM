package com.rockfly.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
	
	private String productType;
	
	private String styleNumber;
	
	private String itemHsnSac;
	
	private String color;
	
	private String productSpecification;	
	
	//Size
	private String size;	
	
	//Quantity
	private String quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "price_id")
	private Price price;
	
	@ManyToMany
	private List<RackNumber> rackNumber;
}
