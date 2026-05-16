package com.example.warehouse.controller;

import com.example.warehouse.common.Result;
import com.example.warehouse.common.ResultUtil;
import com.example.warehouse.entity.ProductInfo;
import com.example.warehouse.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Result<List<ProductInfo>> list() {
        return ResultUtil.success(productService.listAll());
    }

    @GetMapping("/{id}")
    public Result<ProductInfo> get(@PathVariable Long id) {
        return ResultUtil.success(productService.getById(id));
    }

    @PostMapping
    public Result<ProductInfo> create(@RequestBody ProductInfo productInfo) {
        return ResultUtil.success(productService.create(productInfo));
    }

    @PutMapping("/{id}")
    public Result<ProductInfo> update(@PathVariable Long id, @RequestBody ProductInfo productInfo) {
        return ResultUtil.success(productService.update(id, productInfo));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResultUtil.success();
    }
}
