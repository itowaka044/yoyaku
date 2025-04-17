package dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingRequestDTO {
    private String name;
    private String cpf;
    private String phone;
    private LocalDate date;
    private LocalTime time;

    public BookingRequestDTO() {
    }

    public BookingRequestDTO(String name, String cpf, String phone, LocalDate date, LocalTime time) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.date = date;
        this.time = time;
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
}