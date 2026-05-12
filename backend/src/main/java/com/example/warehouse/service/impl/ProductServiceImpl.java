package com.example.warehouse.service.impl;

import com.example.warehouse.entity.ProductInfo;
import com.example.warehouse.mapper.ProductMapper;
import com.example.warehouse.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductInfo> listAll() {
        return productMapper.findAll();
    }

    @Override
    public ProductInfo getById(Long id) {
        return productMapper.findById(id);
    }

    @Override
    public ProductInfo create(ProductInfo productInfo) {
        productMapper.insert(productInfo);
        return productInfo;
    }

    @Override
    public ProductInfo update(Long id, ProductInfo productInfo) {
        productInfo.setId(id);
        productMapper.update(productInfo);
        return productInfo;
    }

    @Override
    public void delete(Long id) {
        productMapper.delete(id);
    }
}
