package com.ms.product.service.product;

import java.math.BigDecimal;

import com.ms.product.service.category.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String description;

	private double availableQuantity;

	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}
