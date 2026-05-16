package com.example.warehouse.service.impl;

import com.example.warehouse.entity.ProductInfo;
import com.example.warehouse.exception.BusinessException;
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
        if (id == null) {
            throw new BusinessException(400, "商品ID不能为空");
        }
        ProductInfo product = productMapper.findById(id);
        if (product == null) {
            throw new BusinessException(400, "商品不存在");
        }
        return product;
    }

    @Override
    public ProductInfo create(ProductInfo productInfo) {
        if (productInfo == null) {
            throw new BusinessException(400, "商品信息不能为空");
        }
        productMapper.insert(productInfo);
        return productInfo;
    }

    @Override
    public ProductInfo update(Long id, ProductInfo productInfo) {
        if (id == null) {
            throw new BusinessException(400, "商品ID不能为空");
        }
        if (productInfo == null) {
            throw new BusinessException(400, "商品信息不能为空");
        }
        ProductInfo existing = productMapper.findById(id);
        if (existing == null) {
            throw new BusinessException(400, "商品不存在");
        }
        productInfo.setId(id);
        productMapper.update(productInfo);
        return productInfo;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BusinessException(400, "商品ID不能为空");
        }
        ProductInfo existing = productMapper.findById(id);
        if (existing == null) {
            throw new BusinessException(400, "商品不存在");
        }
        productMapper.delete(id);
    }
}
