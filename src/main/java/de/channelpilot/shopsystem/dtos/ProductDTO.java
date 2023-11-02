package de.channelpilot.shopsystem.dtos;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {

	@Nonnull
	private Integer productID;
	@Nonnull
	@NotBlank
	private String name;
	@Nonnull
	private Double price;
	private String description;
	private String category;
	private String manufacturer;
	
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
