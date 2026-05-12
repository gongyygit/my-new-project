package com.example.warehouse.mapper;

import com.example.warehouse.entity.ProductInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("SELECT id, warehouse_id, sku, name, unit, quantity FROM product")
    List<ProductInfo> findAll();

    @Select("SELECT id, warehouse_id, sku, name, unit, quantity FROM product WHERE id = #{id}")
    ProductInfo findById(Long id);

    @Insert("INSERT INTO product(warehouse_id, sku, name, unit, quantity) VALUES(#{warehouseId}, #{sku}, #{name}, #{unit}, #{quantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(ProductInfo productInfo);

    @Update("UPDATE product SET warehouse_id = #{warehouseId}, sku = #{sku}, name = #{name}, unit = #{unit}, quantity = #{quantity} WHERE id = #{id}")
    int update(ProductInfo productInfo);

    @Delete("DELETE FROM product WHERE id = #{id}")
    int delete(Long id);
}
