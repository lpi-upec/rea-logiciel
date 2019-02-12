package fr.edenskull.demojpa.controller;

import fr.edenskull.demojpa.model.ProductEntity;
import fr.edenskull.demojpa.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class ProductController {

	private final IProductService productService;

	@Autowired
	public ProductController(IProductService productService) { this.productService = productService; }

	@RequestMapping(method = RequestMethod.POST, path = "/products")
	public ProductEntity post(@RequestBody ProductEntity product) throws SQLException {
		return productService.insert(product);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/products/{id}")
	public ProductEntity get(@PathVariable("id") Long id) throws SQLException {
		ProductEntity product = new ProductEntity();
		product.setId(id);
		return productService.select(product);
	}

}