package co.shubhamgupta.vogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.shubhamgupta.vogue.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsername(String username);
	
}
