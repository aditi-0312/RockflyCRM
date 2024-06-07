package com.rockfly.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

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
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "productTypeId")
	private ProductType productType;
	
	private String styleNumber;
	
	private String itemHsnSac;
	
	private String color;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "productSpecifications_id")
	private ProductSpecifications productSpecifications;	
	
	//Size
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "size_id")
	private Size size;	
	
	//Quantity
	private String quantity;
	
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<RackNumber> rackNumber; 
	
	@CreationTimestamp
	private Date timeStamp;
}
