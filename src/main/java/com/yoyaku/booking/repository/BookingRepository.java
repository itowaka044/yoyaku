package com.yoyaku.booking.repository;

import com.yoyaku.booking.model.Booking;
import com.yoyaku.booking.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByStatus(BookingStatus status);
}