package com.example.warehouse.service;

import com.example.warehouse.entity.InventoryStatistic;
import java.util.List;

public interface InventoryService {
    List<InventoryStatistic> listStatistics();
}
