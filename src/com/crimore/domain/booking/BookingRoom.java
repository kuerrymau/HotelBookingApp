package com.crimore.domain.booking;

import com.crimore.domain.guest.Guest;
import com.crimore.domain.hotel.RoomType;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-09-13.
 */

/**
 * link table for guest, room, booking
 */

@Entity
@Table(name = "BookingRoom")
@Inheritance(strategy = InheritanceType.JOINED)
public class BookingRoom {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "roomTypeID")
    private RoomType roomType;

    @OneToOne
    @JoinColumn(name = "bookingID")
    private Booking booking;
    @OneToOne
    @JoinColumn(name = "guestID")
    private Guest guest;

    public BookingRoom() {
    }

    public BookingRoom(RoomType roomType, Booking booking, Guest guest) {
        this.roomType = roomType;
        this.booking = booking;
        this.guest = guest;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking bookingID) {
        this.booking = bookingID;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingRoom)) return false;
        BookingRoom that = (BookingRoom) o;
        return Objects.equals(roomType, that.roomType) &&
        Objects.equals(booking, that.booking) &&
                Objects.equals(guest, that.guest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomType, booking, guest);
    }
}
