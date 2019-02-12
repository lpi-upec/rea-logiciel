package fr.edenskull.demojpa.service;

import fr.edenskull.demojpa.model.Product;
import fr.edenskull.demojpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	public void insertProduct(Product product) {
		productRepository.save(product);
	}


	public Product getProduct(Long id) {
		return productRepository.findById(id).orElse(null);
	}
}
