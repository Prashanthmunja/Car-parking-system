package com.example.carparking_system.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carparking_system.Model.ParkingSlot;

public interface ParkingRepo extends JpaRepository<ParkingSlot, Long> {
    List<ParkingSlot> findByActiveTrue();
}
