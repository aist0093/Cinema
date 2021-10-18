package com.example.demo.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "booking", schema = "demo31")
public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "booking_id", nullable = false, length = 11)
        private int booking;
        @ManyToOne
        @JoinColumn(name="viewing_id", nullable = false)
        private Viewing viewing;          ///why??
        @Basic
        @Column(name = "email", nullable = false)
        private String email;

    public Booking(Integer viewingId, String email) {


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
