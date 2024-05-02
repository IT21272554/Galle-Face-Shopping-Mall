package com.dev.gallefaceshoppingmall.service;

import com.dev.gallefaceshoppingmall.entity.SlotHistory;
import com.dev.gallefaceshoppingmall.repository.SlotHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotHistoryService {

    @Autowired(required = true)
    SlotHistoryRepository slotHistoryRepository;

    public SlotHistoryService(SlotHistoryRepository slotHistoryRepository) {
        this.slotHistoryRepository = slotHistoryRepository;
    }

    public SlotHistory createSlotHistory(SlotHistory slotHistory) {
        return slotHistoryRepository.save(slotHistory);
    }

    public SlotHistory updateSlotHistory(String _id, SlotHistory slotHistory) {
        slotHistory.set_id(_id);
        return slotHistoryRepository.save(slotHistory);
    }

    public Optional<SlotHistory> getSlotHistoryById(String _id) {
        return slotHistoryRepository.findById(_id);
    }

    public List<SlotHistory> getAllSlotHistories() {
        return slotHistoryRepository.findAll();
    }
}