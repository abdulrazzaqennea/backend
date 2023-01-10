package com.example.fullstackbe.Controller;

import com.example.fullstackbe.Model.Products;
import com.example.fullstackbe.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @PostMapping("/products")
    public void addProducts(@RequestBody List<Products> productsList){
        this.productsService.addProducts(productsList);
    }
    @PostMapping("/product")
    public void addProduct(@RequestBody Products products){
        this.productsService.addProduct(products);
    }
    @GetMapping("/products")
    public List<Products> getProducts(){
        return this.productsService.getProducts();
    }
}
