package com.example.carparking_system.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.carparking_system.Model.BookingSlot;
import com.example.carparking_system.Model.ParkingSlot;
import com.example.carparking_system.Model.user;
import com.example.carparking_system.Repository.ParkingRepo;
import com.example.carparking_system.Repository.userrepo;
import com.example.carparking_system.service.BookingService;

@RestController
@RequestMapping("/api/bookings")

public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private userrepo userRepo;

    @Autowired
    private ParkingRepo parkingRepo;

    @GetMapping("/slots")
    public List<ParkingSlot> getActiveSlots() {
        return bookingService.getActiveSlots();
    }

    @GetMapping("/check-availability/{slotId}")
    public boolean checkSlotAvailability(@PathVariable Long slotId,
                                         @RequestParam String start,
                                         @RequestParam String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        ParkingSlot slot = parkingRepo.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Parking slot not found"));
        return bookingService.isSlotAvailable(slot, startTime, endTime);
    }

    @PostMapping("/create")
    public BookingSlot createBooking(@RequestParam Long userId,
                                     @RequestParam Long slotId,
                                     @RequestParam String start,
                                     @RequestParam String end) {
        user user = new user();
        ParkingSlot slot = parkingRepo.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
        return bookingService.createBooking(user, slot, LocalDateTime.parse(start), LocalDateTime.parse(end));
    }

    @GetMapping("/user/{userId}")
    public List<BookingSlot> getBookingsForUser(@PathVariable Long userId) {
        user user = new user();
        return bookingService.getBookingsForUser(user);
    }

    @PutMapping("/cancel/{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return "Booking cancelled successfully";
    }
}
