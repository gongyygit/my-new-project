package com.example.warehouse.service.impl;

import com.example.warehouse.entity.OutboundRecord;
import com.example.warehouse.exception.BusinessException;
import com.example.warehouse.mapper.OutboundRecordMapper;
import com.example.warehouse.service.OutboundRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutboundRecordServiceImpl implements OutboundRecordService {
    private final OutboundRecordMapper outboundRecordMapper;

    public OutboundRecordServiceImpl(OutboundRecordMapper outboundRecordMapper) {
        this.outboundRecordMapper = outboundRecordMapper;
    }

    @Override
    public List<OutboundRecord> listAll() {
        return outboundRecordMapper.findAll();
    }

    @Override
    public OutboundRecord getById(Long id) {
        if (id == null) {
            throw new BusinessException(400, "出库记录ID不能为空");
        }
        OutboundRecord record = outboundRecordMapper.findById(id);
        if (record == null) {
            throw new BusinessException(400, "出库记录不存在");
        }
        return record;
    }

    @Override
    public OutboundRecord create(OutboundRecord record) {
        if (record == null) {
            throw new BusinessException(400, "出库记录不能为空");
        }
        outboundRecordMapper.insert(record);
        return record;
    }

    @Override
    public OutboundRecord update(Long id, OutboundRecord record) {
        if (id == null) {
            throw new BusinessException(400, "出库记录ID不能为空");
        }
        if (record == null) {
            throw new BusinessException(400, "出库记录不能为空");
        }
        OutboundRecord existing = outboundRecordMapper.findById(id);
        if (existing == null) {
            throw new BusinessException(400, "出库记录不存在");
        }
        record.setId(id);
        outboundRecordMapper.update(record);
        return record;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BusinessException(400, "出库记录ID不能为空");
        }
        OutboundRecord existing = outboundRecordMapper.findById(id);
        if (existing == null) {
            throw new BusinessException(400, "出库记录不存在");
        }
        outboundRecordMapper.delete(id);
    }
}
