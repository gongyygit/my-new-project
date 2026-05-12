package com.example.warehouse.service.impl;

import com.example.warehouse.entity.InboundRecord;
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
        return inboundRecordMapper.findById(id);
    }

    @Override
    public InboundRecord create(InboundRecord record) {
        inboundRecordMapper.insert(record);
        return record;
    }

    @Override
    public InboundRecord update(Long id, InboundRecord record) {
        record.setId(id);
        inboundRecordMapper.update(record);
        return record;
    }

    @Override
    public void delete(Long id) {
        inboundRecordMapper.delete(id);
    }
}
