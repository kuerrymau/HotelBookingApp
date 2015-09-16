package com.crimore.service.booking;

import com.crimore.domain.booking.Booking;
import com.crimore.domain.booking.BookingRoom;
import com.crimore.domain.guest.Guest;
import com.crimore.domain.hotel.Hotel;
import com.crimore.domain.hotel.HotelType;
import com.crimore.domain.hotel.RoomType;
import com.crimore.domain.location.Location;

import java.util.Date;
import java.util.List;

/**
 * Created by cchingwenje on 2015-09-13.
 */
public interface BookingManager {
    Booking makeABooking(Hotel hotel, Date arrivalDate, Date departureDate, Guest guest, RoomType roomType);

    void cancelABooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBookingRoom(Booking booking);

    BookingRoom makeBookingRoom(RoomType roomType, Booking booking, Guest guest);

    Hotel createHotel(String name, Location location, HotelType hotelType);

    Location createLocation(String name);

    HotelType createHotelType(String hotelTypeName);

    RoomType createRoomType(String name, Hotel hotel, float roomRatePerDay, int maxNumberOfPeople);

    Guest createGuest(String firstName, String surname);

    List<RoomType> findAvailableRoomsInLocation();
}
