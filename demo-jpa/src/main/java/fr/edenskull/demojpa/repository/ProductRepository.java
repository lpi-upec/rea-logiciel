package fr.edenskull.demojpa.repository;

import fr.edenskull.demojpa.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long> {



}
