package com.dev.gallefaceshoppingmall.controller;

import com.dev.gallefaceshoppingmall.entity.SlotHistory;
import com.dev.gallefaceshoppingmall.service.SlotHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/slotHistory")
public class SlotHistoryController {

    @Autowired
    SlotHistoryService slotHistoryService;

    @PostMapping
    public SlotHistory createSlotHistory(@RequestBody SlotHistory slotHistory) {
        return slotHistoryService.createSlotHistory(slotHistory);
    }

    @PutMapping("/{_id}")
    public SlotHistory updateSlotHistory(@PathVariable String _id, @RequestBody SlotHistory slotHistory) {
        return slotHistoryService.updateSlotHistory(_id, slotHistory);
    }

    @GetMapping("/{_id}")
    public Optional<SlotHistory> getSlotHistoryById(@PathVariable String _id) {
        return slotHistoryService.getSlotHistoryById(_id);
    }

    @GetMapping
    public List<SlotHistory> getAllSlotHistories() {
        return slotHistoryService.getAllSlotHistories();
    }
}