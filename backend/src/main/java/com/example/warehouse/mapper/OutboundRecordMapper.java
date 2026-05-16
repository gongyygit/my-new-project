package com.example.warehouse.mapper;

import com.example.warehouse.entity.OutboundRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

@Mapper
public interface OutboundRecordMapper {
    @Select("SELECT id, warehouse_id, product_id, quantity, created_at, remark FROM outbound_record")
    List<OutboundRecord> findAll();

    @Select("SELECT id, warehouse_id, product_id, quantity, created_at, remark FROM outbound_record WHERE id = #{id}")
    OutboundRecord findById(Long id);

    @Insert("INSERT INTO outbound_record(warehouse_id, product_id, quantity, created_at, remark) VALUES(#{warehouseId}, #{productId}, #{quantity}, #{createdAt}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(OutboundRecord record);

    @Update("UPDATE outbound_record SET warehouse_id = #{warehouseId}, product_id = #{productId}, quantity = #{quantity}, created_at = #{createdAt}, remark = #{remark} WHERE id = #{id}")
    int update(OutboundRecord record);

    @Delete("DELETE FROM outbound_record WHERE id = #{id}")
    int delete(Long id);
}
