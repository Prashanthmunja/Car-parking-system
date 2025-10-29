package com.example.carparking_system.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class BookingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private user user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "slot_id")
    private ParkingSlot slot;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private Status status = Status.CONFIRMED;

    public enum Status {
        CONFIRMED, CANCELLED, COMPLETED
    }
}
