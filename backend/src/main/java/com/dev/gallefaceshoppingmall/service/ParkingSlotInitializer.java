package com.dev.gallefaceshoppingmall.service;

import com.dev.gallefaceshoppingmall.entity.ParkingSlot;
import com.dev.gallefaceshoppingmall.repository.ParkingSlotRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class ParkingSlotInitializer {

    private final ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotInitializer(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @PostConstruct
    public void initializeParkingSlots() {
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        IntStream.rangeClosed(1, 20)
                .forEach(slotNumber -> parkingSlots.add(new ParkingSlot(null, slotNumber, false, null, null)));
        parkingSlotRepository.saveAll(parkingSlots);
    }
}
