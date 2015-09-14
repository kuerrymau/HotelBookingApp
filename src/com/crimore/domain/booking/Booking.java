package com.crimore.domain.booking;

import com.crimore.domain.guest.Guest;
import com.crimore.domain.hotel.Hotel;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-09-13.
 */

@Entity
@Table(name = "Booking")
@Inheritance(strategy = InheritanceType.JOINED)
public class Booking {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hotelID")
    private Hotel hotel;

    @Temporal(TemporalType.DATE)
    @Column(name = "arrivalDate")
    private Date arrivalDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "departureDate")
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name = "guestID")
    private Guest guest;

    @Column(length = 1024)
    private String comments;

    public Booking(){

    }

    public Booking(Hotel hotel, Date arrivalDate, Date departureDate, Guest guest) {
        this.hotel = hotel;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.guest = guest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(getHotel(), booking.getHotel()) &&
                Objects.equals(getArrivalDate(), booking.getArrivalDate()) &&
                Objects.equals(getDepartureDate(), booking.getDepartureDate()) &&
                Objects.equals(getGuest(), booking.getGuest()) &&
                Objects.equals(getComments(), booking.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHotel(), getArrivalDate(), getDepartureDate(), getGuest(), getComments());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "hotel=" + hotel +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", guest=" + guest +
                ", comments='" + comments + '\'' +
                '}';
    }
}
