package com.example.warehouse.service.impl;

import com.example.warehouse.entity.WarehouseInfo;
import com.example.warehouse.mapper.WarehouseMapper;
import com.example.warehouse.service.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseMapper warehouseMapper;

    public WarehouseServiceImpl(WarehouseMapper warehouseMapper) {
        this.warehouseMapper = warehouseMapper;
    }

    @Override
    public List<WarehouseInfo> listAll() {
        return warehouseMapper.findAll();
    }

    @Override
    public WarehouseInfo getById(Long id) {
        return warehouseMapper.findById(id);
    }

    @Override
    public WarehouseInfo create(WarehouseInfo warehouseInfo) {
        warehouseMapper.insert(warehouseInfo);
        return warehouseInfo;
    }

    @Override
    public WarehouseInfo update(Long id, WarehouseInfo warehouseInfo) {
        warehouseInfo.setId(id);
        warehouseMapper.update(warehouseInfo);
        return warehouseInfo;
    }

    @Override
    public void delete(Long id) {
        warehouseMapper.delete(id);
    }
}
