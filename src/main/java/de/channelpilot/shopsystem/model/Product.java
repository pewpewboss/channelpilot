package de.channelpilot.shopsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/**
 * This entity defines The fields of the table "PRODUCTS" and is inted to be used in the persistence Layer
 */
@Entity
@Table(name="PRODUCTS")
public class Product {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer productID;
	private String name;
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
