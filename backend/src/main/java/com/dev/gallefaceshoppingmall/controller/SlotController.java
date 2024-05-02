package com.dev.gallefaceshoppingmall.controller;

import com.dev.gallefaceshoppingmall.entity.Slot;
import com.dev.gallefaceshoppingmall.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController {

    @Autowired
    private SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveSlot(@RequestBody Slot slot) {
        try {
            slotService.saveSlot(slot);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the slot.");
        }
    }

    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAllSlots(@RequestBody List<Slot> slots) {
        try {
            slotService.saveAllSlots(slots);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while saving the slots.");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Slot>> getAllSlots() {
        List<Slot> slots = slotService.getAllSlots();
        return new ResponseEntity<>(slots, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSlot(@RequestBody Slot slot) {
        try {
            Slot updatedSlot = slotService.updateSlot(slot);
            return ResponseEntity.ok(updatedSlot);
        } catch (RuntimeException e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return an appropriate error response
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("An error occurred while updating the slot: " + e.getMessage());
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Return an appropriate error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating the slot.");
        }
    }
}
