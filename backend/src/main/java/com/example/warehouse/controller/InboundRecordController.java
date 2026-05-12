package com.example.warehouse.controller;

import com.example.warehouse.entity.InboundRecord;
import com.example.warehouse.service.InboundRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inbound")
public class InboundRecordController {
    private final InboundRecordService inboundRecordService;

    public InboundRecordController(InboundRecordService inboundRecordService) {
        this.inboundRecordService = inboundRecordService;
    }

    @GetMapping
    public ResponseEntity<List<InboundRecord>> list() {
        return ResponseEntity.ok(inboundRecordService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InboundRecord> get(@PathVariable Long id) {
        return ResponseEntity.ok(inboundRecordService.getById(id));
    }

    @PostMapping
    public ResponseEntity<InboundRecord> create(@RequestBody InboundRecord record) {
        return ResponseEntity.ok(inboundRecordService.create(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InboundRecord> update(@PathVariable Long id, @RequestBody InboundRecord record) {
        return ResponseEntity.ok(inboundRecordService.update(id, record));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        inboundRecordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
