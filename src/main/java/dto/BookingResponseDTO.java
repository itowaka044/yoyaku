package dto;

import model.BookingStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingResponseDTO {
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private LocalDate date;
    private LocalTime time;
    private BookingStatus status;

    public BookingResponseDTO() {
    }

    public BookingResponseDTO(Long id, String name, String cpf, String phone, LocalDate date, LocalTime time, BookingStatus status) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}