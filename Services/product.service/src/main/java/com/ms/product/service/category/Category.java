package com.ms.product.service.category;

import java.util.List;

import com.ms.product.service.product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Category {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String description;

	@OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
	private List<Product> products;

}
