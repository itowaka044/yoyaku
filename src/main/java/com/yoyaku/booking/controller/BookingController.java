package com.yoyaku.booking.controller;

import com.yoyaku.booking.service.BookingService;
import com.yoyaku.booking.model.Booking;
import com.yoyaku.booking.model.BookingStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*") // alterar antes de ir para prod !!!
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(service.createBooking(booking));
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }

    @GetMapping("/pending")
    public List<Booking> getPendingBookings() {
        return service.getPendingBookings();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Booking> updateBookingStatus(
            @PathVariable Long id,
            @RequestParam BookingStatus newStatus
    ) {
        Optional<Booking> updatedBooking = service.updateBookingStatus(id, newStatus);

        if (updatedBooking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedBooking.get());
    }
}