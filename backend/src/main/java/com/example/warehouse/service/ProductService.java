package com.example.warehouse.service;

import com.example.warehouse.entity.ProductInfo;
import java.util.List;

public interface ProductService {
    List<ProductInfo> listAll();
    ProductInfo getById(Long id);
    ProductInfo create(ProductInfo productInfo);
    ProductInfo update(Long id, ProductInfo productInfo);
    void delete(Long id);
}
