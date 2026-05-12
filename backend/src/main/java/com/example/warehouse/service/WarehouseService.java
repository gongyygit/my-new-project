package com.example.warehouse.service;

import com.example.warehouse.entity.WarehouseInfo;
import java.util.List;

public interface WarehouseService {
    List<WarehouseInfo> listAll();
    WarehouseInfo getById(Long id);
    WarehouseInfo create(WarehouseInfo warehouseInfo);
    WarehouseInfo update(Long id, WarehouseInfo warehouseInfo);
    void delete(Long id);
}
