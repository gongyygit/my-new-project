package com.example.warehouse.controller;

import com.example.warehouse.common.Result;
import com.example.warehouse.common.ResultUtil;
import com.example.warehouse.entity.OutboundRecord;
import com.example.warehouse.service.OutboundRecordService;
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
    public Result<List<OutboundRecord>> list() {
        return ResultUtil.success(outboundRecordService.listAll());
    }

    @GetMapping("/{id}")
    public Result<OutboundRecord> get(@PathVariable Long id) {
        return ResultUtil.success(outboundRecordService.getById(id));
    }

    @PostMapping
    public Result<OutboundRecord> create(@RequestBody OutboundRecord record) {
        return ResultUtil.success(outboundRecordService.create(record));
    }

    @PutMapping("/{id}")
    public Result<OutboundRecord> update(@PathVariable Long id, @RequestBody OutboundRecord record) {
        return ResultUtil.success(outboundRecordService.update(id, record));
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete(@PathVariable Long id) {
        outboundRecordService.delete(id);
        return ResultUtil.success();
    }
}
