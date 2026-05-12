package com.example.warehouse.controller;

import com.example.warehouse.entity.OutboundRecord;
import com.example.warehouse.service.OutboundRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/outbound")
public class OutboundRecordController {
    private final OutboundRecordService outboundRecordService;

    public OutboundRecordController(OutboundRecordService outboundRecordService) {
        this.outboundRecordService = outboundRecordService;
    }

    @GetMapping
    public ResponseEntity<List<OutboundRecord>> list() {
        return ResponseEntity.ok(outboundRecordService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutboundRecord> get(@PathVariable Long id) {
        return ResponseEntity.ok(outboundRecordService.getById(id));
    }

    @PostMapping
    public ResponseEntity<OutboundRecord> create(@RequestBody OutboundRecord record) {
        return ResponseEntity.ok(outboundRecordService.create(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OutboundRecord> update(@PathVariable Long id, @RequestBody OutboundRecord record) {
        return ResponseEntity.ok(outboundRecordService.update(id, record));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        outboundRecordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
