package com.yoyaku.booking.dto;

import com.yoyaku.booking.model.BookingStatus;

public class BookingStatusDTO {

    private BookingStatus newStatus;

    public BookingStatus getNewStatus(){
        return newStatus;
    }

    public void setNewStatus(BookingStatus newStatus){
        this.newStatus = newStatus;
    }
}
