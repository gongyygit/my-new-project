package com.example.warehouse.service;

import com.example.warehouse.entity.InboundRecord;
import java.util.List;

public interface InboundRecordService {
    List<InboundRecord> listAll();
    InboundRecord getById(Long id);
    InboundRecord create(InboundRecord record);
    InboundRecord update(Long id, InboundRecord record);
    void delete(Long id);
}
