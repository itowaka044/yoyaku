package com.yoyaku.booking.mapper;

import com.yoyaku.booking.dto.BookingResponseDTO;
import com.yoyaku.booking.model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingMapper {

    public static BookingResponseDTO toDTO(Booking booking) {
        return new BookingResponseDTO(
                booking.getId(),
                booking.getName(),
                booking.getPhone(),
                booking.getDate(),
                booking.getTime(),
                booking.getStatus()
        );
    }

    public static List<BookingResponseDTO> toDTOList(List<Booking> bookings) {
        List<BookingResponseDTO> dtoList = new ArrayList<>();

        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            dtoList.add(toDTO(booking));
        }

        return dtoList;
    }
}