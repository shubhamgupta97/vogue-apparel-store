package co.shubhamgupta.vogue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.shubhamgupta.vogue.model.Product;
import co.shubhamgupta.vogue.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repository;
	
	@Autowired
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	public List<Product> getProductsSortedByGender(Character gender) {
		if(gender == 'M')
			return repository.findAllByOrderByGenderAsc();
		else
			return repository.findAllByOrderByGenderDesc();
	}
	
	public List<Product> getProductsSortedByNewArrival() {
		return repository.findAllByOrderByIsNewArrivalDesc();
	}
	
	public List<Product> getProductsSortedByDiscount() {
		return repository.findAllByOrderByDiscountDesc();
	}
	
	public List<Product> getProductsFilteredByGender(Character gender) {
		return repository.findAllByGender(gender);
	}

	public List<Product> getProductsFilteredByNewArrival() {
		return repository.findAllByIsNewArrival();
	}

	public List<Product> getProductsFilteredByDiscount() {
		return repository.findAllByDiscount();
	}
	
	public List<Product> getProductsFilteredBySearchKeyword(String keyword) {
		return repository.search(keyword);
	}

	public Product getProductById(long id) {
		return repository.getById(id);
	}
}
