package service;

import repository.ProductRepo;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.RecordNotFoundException;

import java.util.List;
import java.util.Optional;

/***
 * Product service interface implementation
  */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productRepo.findProductByName(name);
    }
    
    @Override
    public void delete(Integer id) throws RecordNotFoundException {

	log.info(String.format("[DELETE PRODUCT BY ID]: %s", id));
	
	if (!findById(id).isPresent()) {
	    throw new RecordNotFoundException();
	}

	productRepo.deleteById(id);

    }


    @Override
    public String saveProduct(Product product) {
        Product savePoduct = productRepo.save(product);
        if (savePoduct != null && savePoduct.getName() != "") {
            return "PRODUCT WAS SUCCESSFULLY SAVED";
        }
        return "PLEASE TRY AGAIN< PRODUCT NOT SAVED";
    }
    
    @Override
    public Optional<Product> findById(Integer id) {	
	return productRepo.findById(id);

    }
}
