package com.rockfly.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Long quantityAvailable;
	
	private Long minQuantity;
	
	private LocalDate dateAdded;
	
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="price_id")
	private Price price;

}
