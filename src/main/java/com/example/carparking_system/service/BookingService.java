package com.example.carparking_system.service;

import com.example.carparking_system.Model.BookingSlot;
import com.example.carparking_system.Model.ParkingSlot;
import com.example.carparking_system.Model.user;

import com.example.carparking_system.Repository.BookingRepo;
import com.example.carparking_system.Repository.ParkingRepo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;
    private final ParkingRepo parkingRepo;

    public BookingService(BookingRepo bookingRepo, ParkingRepo parkingRepo) {
        this.bookingRepo = bookingRepo;
        this.parkingRepo = parkingRepo;
    }

    public List<ParkingSlot> getActiveSlots() {
        return parkingRepo.findByActiveTrue();
    }

    public boolean isSlotAvailable(ParkingSlot slot, LocalDateTime start, LocalDateTime end) {
        List<BookingSlot> overlaps = bookingRepo.findOverlappingBookings(slot, start, end);
        return overlaps.isEmpty();
    }

    @Transactional
    public BookingSlot createBooking(user user, ParkingSlot slot, LocalDateTime start, LocalDateTime end) {
        if (!isSlotAvailable(slot, start, end)) {
            throw new IllegalStateException("Parking slot is not available for the selected time.");
        }

        BookingSlot booking = new BookingSlot();
        booking.setUser(user);
        booking.setSlot(slot);
        booking.setStartTime(start);
        booking.setEndTime(end);
        booking.setStatus(BookingSlot.Status.CONFIRMED);

        return bookingRepo.save(booking);
    }

    @Transactional
    public void cancelBooking(Long bookingId) {
        BookingSlot booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + bookingId));

        booking.setStatus(BookingSlot.Status.CANCELLED);
        bookingRepo.save(booking);
    }

    public List<BookingSlot> getBookingsForUser(user user) {
        return bookingRepo.findByUser(user);
    }

    public List<BookingSlot> getBookingsForSlot(ParkingSlot slot) {
        return bookingRepo.findBySlot(slot);
    }
}
