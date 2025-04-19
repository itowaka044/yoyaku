package com.yoyaku.booking.controller;

import com.yoyaku.booking.dto.BookingResponseDTO;
import com.yoyaku.booking.dto.BookingStatusDTO;
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

    private BookingResponseDTO responseDTO(Booking booking) {
        return new BookingResponseDTO(
                booking.getId(),
                booking.getName(),
                booking.getPhone(),
                booking.getDate(),
                booking.getTime(),
                booking.getStatus()
        );
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
            @RequestBody BookingStatusDTO statusDTO
    ) {
        BookingStatus newStatus = statusDTO.getNewStatus();

        Optional<Booking> updatedBooking = service.updateBookingStatus(id, newStatus);

        if (updatedBooking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedBooking.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getById(@PathVariable Long id) {
        Optional<Booking> booking = service.findById(id);

        if (booking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(responseDTO(booking.get()));
    }

}