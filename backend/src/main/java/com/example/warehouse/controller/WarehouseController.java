package com.example.warehouse.controller;

import com.example.warehouse.common.Result;
import com.example.warehouse.common.ResultUtil;
import com.example.warehouse.entity.WarehouseInfo;
import com.example.warehouse.service.WarehouseService;
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
    public Result<List<WarehouseInfo>> list() {
        return ResultUtil.success(warehouseService.listAll());
    }

    @GetMapping("/{id}")
    public Result<WarehouseInfo> get(@PathVariable Long id) {
        return ResultUtil.success(warehouseService.getById(id));
    }

    @PostMapping
    public Result<WarehouseInfo> create(@RequestBody WarehouseInfo warehouseInfo) {
        return ResultUtil.success(warehouseService.create(warehouseInfo));
    }

    @PutMapping("/{id}")
    public Result<WarehouseInfo> update(@PathVariable Long id, @RequestBody WarehouseInfo warehouseInfo) {
        return ResultUtil.success(warehouseService.update(id, warehouseInfo));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        warehouseService.delete(id);
        return ResultUtil.success();
    }
}
