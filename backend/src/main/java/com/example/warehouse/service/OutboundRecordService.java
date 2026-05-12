package com.example.warehouse.service;

import com.example.warehouse.entity.OutboundRecord;
import java.util.List;

public interface OutboundRecordService {
    List<OutboundRecord> listAll();
    OutboundRecord getById(Long id);
    OutboundRecord create(OutboundRecord record);
    OutboundRecord update(Long id, OutboundRecord record);
    void delete(Long id);
}
