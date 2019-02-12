package fr.edenskull.demojpa.controller;

import fr.edenskull.demojpa.model.Product;
import fr.edenskull.demojpa.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/product")
	public void post(@RequestBody Product product) {
		productService.insertProduct(product);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/product/{id}")
	public Product get(@PathVariable("id") Long id) {
		return productService.getProduct(id);
	}

}