package fr.edenskull.demojpa.service;

import fr.edenskull.demojpa.model.ProductEntity;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
	ProductEntity insert(ProductEntity product) throws SQLException;
	void update(ProductEntity product) throws SQLException;
	void delete(ProductEntity product) throws SQLException;
	ProductEntity select(ProductEntity product) throws SQLException;
	List<ProductEntity> selectAll() throws SQLException;
}
