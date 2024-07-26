package service;



import java.util.List;
import java.util.Optional;

import exception.RecordNotFoundException;
import model.Product;

public interface ProductService {
    List<Product> findAllProducts();
    Optional<Product> findProductByName(String name);
    String saveProduct(Product product);
    void delete(Integer id) throws RecordNotFoundException;
	Optional<Product> findById(Integer id);
}
