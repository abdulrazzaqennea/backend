package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.Products;
import com.example.fullstackbe.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{
    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public void addProducts(List<Products> productsList){
        productsRepository.saveAll(productsList);
    }
    @Override
    public void addProduct(Products products){
        productsRepository.save(products);
    }
    @Override
    public List<Products> getProducts(){
        return productsRepository.findAll();
    }
}
