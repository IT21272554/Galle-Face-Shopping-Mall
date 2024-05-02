package com.dev.gallefaceshoppingmall.service;

import com.dev.gallefaceshoppingmall.entity.Slot;
import com.dev.gallefaceshoppingmall.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {

    @Autowired(required = true)
    SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public Slot saveSlot(Slot slot) {
        return slotRepository.save(slot);
    }

    public List<Slot> saveAllSlots(List<Slot> slots) {
        return slotRepository.saveAll(slots);
    }

    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    public Slot updateSlot(Slot slot) {
        if (slotRepository.existsById(slot.get_id())) {
            return slotRepository.save(slot);
        } else {
            throw new RuntimeException("Slot not found with id: " + slot.get_id());
        }
    }
}