package co.shubhamgupta.vogue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String category;
	private String name;
	private Character gender;
	private Double price;
	private Double discount;
	private Boolean isNewArrival;
	private String image;
	
	public Product() {
	}
	public Product(String category, String name, Character gender, Double price, Double discount,
			Boolean isNewArrival, String image) {
		this.category = category;
		this.name = name;
		this.gender = gender;
		this.price = price;
		this.discount = discount;
		this.isNewArrival = isNewArrival;
		this.image = image;
	}
	public Product(Long id, String category, String name, Character gender, Double price, Double discount,
			Boolean isNewArrival, String image) {
		this.id = id;
		this.category = category;
		this.name = name;
		this.gender = gender;
		this.price = price;
		this.discount = discount;
		this.isNewArrival = isNewArrival;
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Boolean getIsNewArrival() {
		return isNewArrival;
	}
	public void setIsNewArrival(Boolean isNewArrival) {
		this.isNewArrival = isNewArrival;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", name=" + name + ", gender=" + gender + ", price="
				+ price + ", discount=" + discount + ", isNewArrival=" + isNewArrival + ", image=" + image + "]";
	}
	
}
