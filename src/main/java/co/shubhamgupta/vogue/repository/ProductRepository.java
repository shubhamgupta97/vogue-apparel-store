package co.shubhamgupta.vogue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.shubhamgupta.vogue.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findAllByOrderByGenderAsc();
	public List<Product> findAllByOrderByGenderDesc();
	public List<Product> findAllByOrderByIsNewArrivalDesc();
	public List<Product> findAllByOrderByDiscountDesc();
	
	@Query(value = "SELECT * FROM product WHERE GENDER = ?1", nativeQuery = true)
	public List<Product> findAllByGender(Character gender);
	
	@Query(value = "SELECT * FROM product WHERE IS_NEW_ARRIVAL = TRUE", nativeQuery = true)
	public List<Product> findAllByIsNewArrival();
	
	@Query(value = "SELECT * FROM product WHERE DISCOUNT > 0.0", nativeQuery = true)
	public List<Product> findAllByDiscount();
	
	@Query(value = "SELECT * FROM product WHERE CONCAT('',category,'', name,'', gender,'') LIKE %?1%", nativeQuery = true)
	public List<Product> search(String keyword);
	
}
