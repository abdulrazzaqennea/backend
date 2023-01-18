package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.Products;

import java.util.List;

public interface ProductsService {
    public void addProducts(List<Products> Products);
    public List<Products> getProducts();

    public void addProduct(Products products);
}
