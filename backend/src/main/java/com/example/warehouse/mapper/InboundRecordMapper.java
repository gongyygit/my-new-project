package com.example.warehouse.mapper;

import com.example.warehouse.entity.InboundRecord;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface InboundRecordMapper {
    @Select("SELECT id, warehouse_id, product_id, quantity, created_at, remark FROM inbound_record")
    List<InboundRecord> findAll();

    @Select("SELECT id, warehouse_id, product_id, quantity, created_at, remark FROM inbound_record WHERE id = #{id}")
    InboundRecord findById(Long id);

    @Insert("INSERT INTO inbound_record(warehouse_id, product_id, quantity, created_at, remark) VALUES(#{warehouseId}, #{productId}, #{quantity}, #{createdAt}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(InboundRecord record);

    @Update("UPDATE inbound_record SET warehouse_id = #{warehouseId}, product_id = #{productId}, quantity = #{quantity}, created_at = #{createdAt}, remark = #{remark} WHERE id = #{id}")
    int update(InboundRecord record);

    @Delete("DELETE FROM inbound_record WHERE id = #{id}")
    int delete(Long id);
}
