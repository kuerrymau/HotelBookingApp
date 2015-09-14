package com.crimore.domain.booking;

import com.crimore.domain.hotel.RoomType;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-09-13.
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
    private Booking bookingID;

    public BookingRoom() {
    }

    public BookingRoom(RoomType roomType, Booking bookingID) {
        this.roomType = roomType;
        this.bookingID = bookingID;
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

    public Booking getBookingID() {
        return bookingID;
    }

    public void setBookingID(Booking bookingID) {
        this.bookingID = bookingID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingRoom)) return false;
        BookingRoom that = (BookingRoom) o;
        return Objects.equals(roomType, that.roomType) &&
        Objects.equals(bookingID, that.bookingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomType, bookingID);
    }
}
