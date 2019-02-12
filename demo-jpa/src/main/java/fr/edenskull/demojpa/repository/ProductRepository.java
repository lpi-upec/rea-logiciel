package fr.edenskull.demojpa.repository;

import fr.edenskull.demojpa.model.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <ProductEntity, Long> {
}
