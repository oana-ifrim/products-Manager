package controller;

import model.Product;
import service.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import exception.RecordNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;


/***
 * Controller to manage products
 *
 */

@Log4j2
@RestController
@RequestMapping

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String goHome(){
        return "Welcome. You are at Home.";
    }
    
    /***
     * Return all products in the database
     * 
     */
    
    @GetMapping("/product/all")
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }
    
    /**
     * Delete a product from the database
     * 
     *
     * @param id Product id
     * @return 
     * 
     * HTTP Status:
     * 200 - OK: Everything worked as expected.
     * 404 - Not found: Product not found on database
     * 500: Something wrong on API
     * 
     * @throws RecordNotFoundException Product not found
     */
    @DeleteMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ApiOperation(value = "Delete product", response = Void.class, tags = "products")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Product deleted"),
	    @ApiResponse(code = 404, message = "Product not exist in the database"),
	    @ApiResponse(code = 500, message = "An exception ocurred") })
    public ResponseEntity<Void> delete(
	    @ApiParam(name = "id", type = "Integer", value = "product id", example = "0001", required = true) @PathVariable(value = "id", required = true) Integer id)
	    throws RecordNotFoundException {

    	productService.delete(id);

	return ResponseEntity.ok().build();
    }

    @GetMapping("/product/{name}")
    public Optional<Product> findProductByName(@PathVariable String name){
        return productService.findProductByName(name);
    }
    @PostMapping("/product/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

}