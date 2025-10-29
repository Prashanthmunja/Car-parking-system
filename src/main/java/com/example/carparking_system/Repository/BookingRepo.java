package com.example.carparking_system.Repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.carparking_system.Model.BookingSlot;
import com.example.carparking_system.Model.ParkingSlot;
import com.example.carparking_system.Model.user;

public interface BookingRepo extends JpaRepository<BookingSlot, Long> {

    @Query("SELECT b FROM BookingSlot b WHERE b.slot = :slot " +
           "AND (b.startTime < :end AND b.endTime > :start)")
    List<BookingSlot> findOverlappingBookings(
            @Param("slot") ParkingSlot slot,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    List<BookingSlot> findByUser(user user);
    List<BookingSlot> findBySlot(ParkingSlot slot);
}
