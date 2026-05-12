package com.example.warehouse.controller;

import com.example.warehouse.entity.InventoryStatistic;
import com.example.warehouse.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<InventoryStatistic>> statistics() {
        return ResponseEntity.ok(inventoryService.listStatistics());
    }
}
