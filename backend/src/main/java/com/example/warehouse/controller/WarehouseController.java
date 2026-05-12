package com.example.warehouse.controller;

import com.example.warehouse.entity.WarehouseInfo;
import com.example.warehouse.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public ResponseEntity<List<WarehouseInfo>> list() {
        return ResponseEntity.ok(warehouseService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseInfo> get(@PathVariable Long id) {
        return ResponseEntity.ok(warehouseService.getById(id));
    }

    @PostMapping
    public ResponseEntity<WarehouseInfo> create(@RequestBody WarehouseInfo warehouseInfo) {
        return ResponseEntity.ok(warehouseService.create(warehouseInfo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WarehouseInfo> update(@PathVariable Long id, @RequestBody WarehouseInfo warehouseInfo) {
        return ResponseEntity.ok(warehouseService.update(id, warehouseInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        warehouseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
