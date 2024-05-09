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
public class Sales_Stock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

}
