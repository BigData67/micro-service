package com.formation.api;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dao.ProductRepository;
import com.formation.entities.Product;

@RestController
@RequestMapping("/products")
public class ProductApi {
	
	protected Logger logger = Logger.getLogger(ProductApi.class.getName());
	
	@Autowired
	private ProductRepository productRepository;
	
    @GetMapping("/list")
    public Iterable<Product> list(){
        Iterable<Product> productList = productRepository.findAll();
        return productList;
    }

    @GetMapping("/show/{id}")
    public Product showProduct(@PathVariable Long id){
       Product product = productRepository.findOne(id);
        return product;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
    	productRepository.save(product);
        //return new ResponseEntity("Product saved successfully", HttpStatus.OK);
        return ResponseEntity.ok(product);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product storedProduct = productRepository.findOne(id);
        storedProduct.setName(product.getName());
        storedProduct.setPrice(product.getPrice());
        storedProduct.setQuantity(product.getQuantity());
        storedProduct.setVersion(product.getVersion());
        productRepository.save(storedProduct);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){
    	Product product = productRepository.findOne(id);
	    if(product == null) {
	        return ResponseEntity.notFound().build();
	    }

	    productRepository.delete(product);
	    return ResponseEntity.ok().build();
    }


}
