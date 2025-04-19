package com.yoyaku.booking.service;

import com.yoyaku.booking.model.Booking;
import com.yoyaku.booking.model.BookingStatus;
import org.springframework.stereotype.Service;
import com.yoyaku.booking.repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(Booking booking) {
        booking.setStatus(BookingStatus.PENDING);
        return repository.save(booking);
    }


    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public List<Booking> getPendingBookings() {
        return repository.findByStatus(BookingStatus.PENDING);
    }

    public Optional<Booking> updateBookingStatus(Long bookingId, BookingStatus newStatus) {
        Optional<Booking> bookingOptional = repository.findById(bookingId);

        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setStatus(newStatus);
            repository.save(booking);
        }

        return bookingOptional;
    }

    public Optional<Booking> findById(Long id) {
        return repository.findById(id);
    }
}