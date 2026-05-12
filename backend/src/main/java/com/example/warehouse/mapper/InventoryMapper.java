package com.example.warehouse.mapper;

import com.example.warehouse.entity.InventoryStatistic;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface InventoryMapper {
    @Select("SELECT p.id as product_id, p.name as product_name, p.warehouse_id as warehouse_id, w.name as warehouse_name, " +
            "IFNULL(i.total_in, 0) as total_in, IFNULL(o.total_out, 0) as total_out, " +
            "IFNULL(i.total_in, 0) - IFNULL(o.total_out, 0) as available " +
            "FROM product p " +
            "JOIN warehouse w ON p.warehouse_id = w.id " +
            "LEFT JOIN (SELECT product_id, SUM(quantity) AS total_in FROM inbound_record GROUP BY product_id) i ON i.product_id = p.id " +
            "LEFT JOIN (SELECT product_id, SUM(quantity) AS total_out FROM outbound_record GROUP BY product_id) o ON o.product_id = p.id")
    List<InventoryStatistic> listStatistics();
}
