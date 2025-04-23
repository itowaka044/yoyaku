package com.yoyaku.booking.controller;

import com.yoyaku.booking.dto.BookingResponseDTO;
import com.yoyaku.booking.dto.BookingStatusDTO;
import com.yoyaku.booking.mapper.BookingMapper;
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
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = service.createBooking(booking);
        return ResponseEntity.ok(BookingMapper.toDTO(savedBooking));
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
        List<Booking> bookings = service.getAllBookings();
        return ResponseEntity.ok(BookingMapper.toDTOList(bookings));
    }

    @GetMapping("/pending")
    public ResponseEntity<List<BookingResponseDTO>> getPendingBookings() {
        List<Booking> bookings = service.getPendingBookings();
        return ResponseEntity.ok(BookingMapper.toDTOList(bookings));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> updateBookingStatus(
            @PathVariable Long id,
            @RequestBody BookingStatusDTO statusDTO
    ) {
        BookingStatus newStatus = statusDTO.getNewStatus();

        Optional<Booking> updatedBooking = service.updateBookingStatus(id, newStatus);

        if (updatedBooking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        BookingResponseDTO bookingResponseDTO = BookingMapper.toDTO(updatedBooking.get());

        return ResponseEntity.ok(bookingResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getById(@PathVariable Long id) {
        Optional<Booking> booking = service.findById(id);

        if (booking.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(BookingMapper.toDTO(booking.get()));
    }

}