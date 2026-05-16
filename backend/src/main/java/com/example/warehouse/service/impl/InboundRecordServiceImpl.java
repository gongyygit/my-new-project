package com.example.warehouse.service.impl;

import com.example.warehouse.entity.InboundRecord;
import com.example.warehouse.exception.BusinessException;
import com.example.warehouse.mapper.InboundRecordMapper;
import com.example.warehouse.service.InboundRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InboundRecordServiceImpl implements InboundRecordService {
    private final InboundRecordMapper inboundRecordMapper;

    public InboundRecordServiceImpl(InboundRecordMapper inboundRecordMapper) {
        this.inboundRecordMapper = inboundRecordMapper;
    }

    @Override
    public List<InboundRecord> listAll() {
        return inboundRecordMapper.findAll();
    }

    @Override
    public InboundRecord getById(Long id) {
        if (id == null) {
            throw new BusinessException(400, "入库记录ID不能为空");
        }
        InboundRecord record = inboundRecordMapper.findById(id);
        if (record == null) {
            throw new BusinessException(400, "入库记录不存在");
        }
        return record;
    }

    @Override
    public InboundRecord create(InboundRecord record) {
        if (record == null) {
            throw new BusinessException(400, "入库记录不能为空");
        }
        inboundRecordMapper.insert(record);
        return record;
    }

    @Override
    public InboundRecord update(Long id, InboundRecord record) {
        if (id == null) {
            throw new BusinessException(400, "入库记录ID不能为空");
        }
        if (record == null) {
            throw new BusinessException(400, "入库记录不能为空");
        }
        InboundRecord existing = inboundRecordMapper.findById(id);
        if (existing == null) {
            throw new BusinessException(400, "入库记录不存在");
        }
        record.setId(id);
        inboundRecordMapper.update(record);
        return record;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new BusinessException(400, "入库记录ID不能为空");
        }
        InboundRecord existing = inboundRecordMapper.findById(id);
        if (existing == null) {
            throw new BusinessException(400, "入库记录不存在");
        }
        inboundRecordMapper.delete(id);
    }
}
