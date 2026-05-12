package com.example.warehouse.service.impl;

import com.example.warehouse.entity.OutboundRecord;
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
        return outboundRecordMapper.findById(id);
    }

    @Override
    public OutboundRecord create(OutboundRecord record) {
        outboundRecordMapper.insert(record);
        return record;
    }

    @Override
    public OutboundRecord update(Long id, OutboundRecord record) {
        record.setId(id);
        outboundRecordMapper.update(record);
        return record;
    }

    @Override
    public void delete(Long id) {
        outboundRecordMapper.delete(id);
    }
}
