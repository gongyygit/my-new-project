package com.example.warehouse.mapper;

import com.example.warehouse.entity.WarehouseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;

@Mapper
public interface WarehouseMapper {
    @Select("SELECT id, name, location, contact FROM warehouse")
    List<WarehouseInfo> findAll();

    @Select("SELECT id, name, location, contact FROM warehouse WHERE id = #{id}")
    WarehouseInfo findById(Long id);

    @Insert("INSERT INTO warehouse(name, location, contact) VALUES(#{name}, #{location}, #{contact})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(WarehouseInfo warehouseInfo);

    @Update("UPDATE warehouse SET name = #{name}, location = #{location}, contact = #{contact} WHERE id = #{id}")
    int update(WarehouseInfo warehouseInfo);

    @Delete("DELETE FROM warehouse WHERE id = #{id}")
    int delete(Long id);
}
