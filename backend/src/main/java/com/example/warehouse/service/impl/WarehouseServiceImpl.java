package com.example.warehouse.service.impl;

import com.example.warehouse.entity.WarehouseInfo;
import com.example.warehouse.exception.BusinessException;
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
        if (id == null) {
            throw new BusinessException(400, "仓库ID不能为空");
        }
        WarehouseInfo warehouse = warehouseMapper.findById(id);
        if (warehouse == null) {
            throw new BusinessException(400, "仓库不存在");
        }
        return warehouse;
    }

    @Override
    public WarehouseInfo create(WarehouseInfo warehouseInfo) {
        if (warehouseInfo == null) {
            throw new BusinessException(400, "仓库信息不能为空");
        }
        warehouseMapper.insert(warehouseInfo);
        return warehouseInfo;
    }

    @Override
    public WarehouseInfo update(Long id, WarehouseInfo warehouseInfo) {
        if (id == null) {
            throw new BusinessException(400, "仓库ID不能为空");
        }
        if (warehouseInfo == null) {
            throw new BusinessException(400, "仓库信息不能为空");
        }
        WarehouseInfo existing = warehouseMapper.findById(id);
        if (existing == null) {
            throw new BusinessException(400, "仓库不存在");
        }
        warehouseInfo.setId(id);
        warehouseMapper.update(warehouseInfo);
        return warehouseInfo;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BusinessException(400, "仓库ID不能为空");
        }
        WarehouseInfo existing = warehouseMapper.findById(id);
        if (existing == null) {
            throw new BusinessException(400, "仓库不存在");
        }
        warehouseMapper.delete(id);
    }
}
