package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Product;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

/***
 * Product repositry interface implementation
  */
public interface ProductRepo extends JpaRepository<Product, Integer>{
    @Query(value = "select * from products where name = ?1", nativeQuery = true)
    public Optional<Product> findProductByName(String name);
    
    @Query(value = "delete * from products where id = ?1", nativeQuery = true)
    public void deleteById(Integer id);
   
}