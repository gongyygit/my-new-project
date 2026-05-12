package com.example.warehouse.service.impl;

import com.example.warehouse.entity.InventoryStatistic;
import com.example.warehouse.mapper.InventoryMapper;
import com.example.warehouse.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryMapper inventoryMapper;

    public InventoryServiceImpl(InventoryMapper inventoryMapper) {
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public List<InventoryStatistic> listStatistics() {
        return inventoryMapper.listStatistics();
    }
}
