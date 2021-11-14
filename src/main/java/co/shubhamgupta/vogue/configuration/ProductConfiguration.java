package co.shubhamgupta.vogue.configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.shubhamgupta.vogue.model.Product;
import co.shubhamgupta.vogue.repository.ProductRepository;

@Configuration
public class ProductConfiguration {
	
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository repository) {
		return args -> {
			Product nikeAirJordan = new Product(
					"Shoes",
					"Nike Air Jordan",
					'M',
					11750.0,
					0.0,
					true,
					"1.jpeg"
			);
					
			Product sristiKurti = new Product(
					"Kurti",
					"Sristi Kurti",
					'W',
					1900.0,
					15.0,
					false,
					"2.jpeg"
			);
			
			Product khankudiStripedShirt = new Product(
					"Shirt",
					"Khankudi Striped Shirt",
					'M',
					499.0,
					20.0,
					true,
					"3.jpeg"
			);
			
			Product roadsterOliveGreenShirt = new Product(
					"Shirt",
					"Roadster Olive Shirt",
					'M',
					1999.0,
					50.0,
					false,
					"4.jpeg"
			);
			
			repository.saveAll(List.of(nikeAirJordan, sristiKurti, khankudiStripedShirt, roadsterOliveGreenShirt));
		};
	}
	
}
