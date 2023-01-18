package com.example.fullstackbe.Controller;

import com.example.fullstackbe.Model.Products;
import com.example.fullstackbe.Services.ProductsService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductsController {
    Logger logger = LoggerFactory.getLogger(ProductsController.class);
    @Autowired
    private ProductsService productsService;
    @PostMapping("/getproducts")
    public void addProducts(@RequestBody List<Products> productsList){
        this.productsService.addProducts(productsList);
    }
    @PostMapping("/addproduct")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void addProduct(@Valid @RequestBody Products products) {
        logger.info("New Product added.");
        this.productsService.addProduct(products);
    }
    @GetMapping("/getproducts")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public List<Products> getProducts(){
        return this.productsService.getProducts();
    }
}
