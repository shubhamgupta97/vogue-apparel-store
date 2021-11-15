package co.shubhamgupta.vogue.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.shubhamgupta.vogue.service.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;
//	private List<Product> products;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(value = "/")
	public String renderIndex(@RequestParam("q") Optional<String> q, @RequestParam("v") Optional<String> v,
			Model model) {
		// products = productService.getProducts();

		if (q.isPresent()) {
			processQueryParam(q, v, model);
		} else
			model.addAttribute("products", productService.getProducts());

		return "index";
	}

	@GetMapping(value = "/search")
	public String renderIndexOnSearch(@RequestParam("q") Optional<String> q,Model model) {

		if (q.isPresent()) {
			String qValue = q.get();
			model.addAttribute("products", productService.getProductsFilteredBySearchKeyword(qValue));
		} else
			model.addAttribute("products", productService.getProducts());

		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	private void processQueryParam(Optional<String> q, Optional<String> v, Model model) {
		if (v.isPresent()) {
			String qValue = q.get();

			if (qValue.equals("sortBy")) {
				String vValue = v.get();
				if (vValue.equals("new"))
					model.addAttribute("products", productService.getProductsSortedByNewArrival());
				else if (vValue.equals("discount"))
					model.addAttribute("products", productService.getProductsSortedByDiscount());
				else if (vValue.equals("men"))
					model.addAttribute("products", productService.getProductsSortedByGender('M'));
				else if (vValue.equals("women"))
					model.addAttribute("products", productService.getProductsSortedByGender('W'));
				else
					model.addAttribute("products", productService.getProducts());
			}

			else if (qValue.equals("filterBy")) {
				String vValue = v.get();

				if (vValue.equals("men"))
					model.addAttribute("products", productService.getProductsFilteredByGender('M'));
				else if (vValue.equals("women"))
					model.addAttribute("products", productService.getProductsFilteredByGender('W'));
				else if (vValue.equals("new"))
					model.addAttribute("products", productService.getProductsFilteredByNewArrival());
				else if (vValue.equals("discount"))
					model.addAttribute("products", productService.getProductsFilteredByDiscount());
				else
					model.addAttribute("products", productService.getProducts());
			}

		} else
			model.addAttribute("products", productService.getProducts());
	}

}
