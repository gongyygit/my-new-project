package com.example.warehouse.controller;

import com.example.warehouse.common.Result;
import com.example.warehouse.common.ResultUtil;
import com.example.warehouse.entity.InboundRecord;
import com.example.warehouse.service.InboundRecordService;
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
    public Result<List<InboundRecord>> list() {
        return ResultUtil.success(inboundRecordService.listAll());
    }

    @GetMapping("/{id}")
    public Result<InboundRecord> get(@PathVariable Long id) {
        return ResultUtil.success(inboundRecordService.getById(id));
    }

    @PostMapping
    public Result<InboundRecord> create(@RequestBody InboundRecord record) {
        return ResultUtil.success(inboundRecordService.create(record));
    }

    @PutMapping("/{id}")
    public Result<InboundRecord> update(@PathVariable Long id, @RequestBody InboundRecord record) {
        return ResultUtil.success(inboundRecordService.update(id, record));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        inboundRecordService.delete(id);
        return ResultUtil.success();
    }
}
