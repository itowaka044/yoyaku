package service;

import model.Booking;
import model.BookingStatus;
import org.springframework.stereotype.Service;
import repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public Booking createBooking(Booking booking) {
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
}