package com.rockfly.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String productName;
	
	private String sizeType;
	
	@OneToOne(mappedBy = "productType")
	private MainStock mainStock;
	
	@OneToMany(mappedBy = "productType")
	private List<ProductSpecifications> productSpecifications;
	
	@ManyToMany
	private List<Size> size;
	
	@CreationTimestamp
	private Date timeStamp;
}
