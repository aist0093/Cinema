package com.example.demo.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false, length = 11)
    private int booking;
    @ManyToOne
    @JoinColumn(name = "viewing_id")
    private Viewing viewing;
    @Basic
    @Column(name = "email")
    private String email;

    public Booking(Viewing viewing, String email) {
        this.viewing = viewing;
        this.email = email;

    }

    public int getBooking() {
        return booking;
    }

    public Viewing getViewing() {
        return viewing;
    }

    public void setViewing(Viewing viewing) {
        this.viewing = viewing;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
