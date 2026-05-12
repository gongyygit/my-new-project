package com.example.warehouse.controller;

import com.example.warehouse.entity.ProductInfo;
import com.example.warehouse.service.ProductService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProductInfo>> list() {
        return ResponseEntity.ok(productService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductInfo> get(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProductInfo> create(@RequestBody ProductInfo productInfo) {
        return ResponseEntity.ok(productService.create(productInfo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductInfo> update(@PathVariable Long id, @RequestBody ProductInfo productInfo) {
        return ResponseEntity.ok(productService.update(id, productInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
