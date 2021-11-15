package co.shubhamgupta.vogue.configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.shubhamgupta.vogue.model.User;
import co.shubhamgupta.vogue.repository.UserRepository;

@Configuration
public class UserConfiguration {
	@Bean
	CommandLineRunner commandLineRunner2(UserRepository repository) {
		return args -> {
			User shubham = new User(
					"shubham",
					"$2a$12$fyrcQNGxfGuTyMfQjIk/TOcce3uoS8WCELDNnxSQbNl3WS8W3Y81y",
					'M'
			);
			
			User utsav = new User(
					"utsav",
					"$2a$12$fyrcQNGxfGuTyMfQjIk/TOcce3uoS8WCELDNnxSQbNl3WS8W3Y81y",
					'M'
			);
			
			User vaani = new User(
					"vaani",
					"$2a$12$g18SCINUfLEELpOhlyWqnuRuDHBszWBWgKt275oOOCdQ6OGj4E7mm",
					'W'
			);
			
			repository.saveAll(List.of(shubham, vaani, utsav));
		};
	}
}
