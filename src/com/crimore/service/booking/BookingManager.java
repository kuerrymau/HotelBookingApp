package com.crimore.service.booking;

import com.crimore.domain.booking.Booking;
import com.crimore.domain.guest.Guest;
import com.crimore.domain.hotel.Hotel;
import com.crimore.domain.hotel.HotelType;
import com.crimore.domain.location.Location;

import java.util.Date;

/**
 * Created by cchingwenje on 2015-09-13.
 */
public interface BookingManager {
    Booking makeBooking(Hotel hotel, Date arrivalDate, Date departureDate, Guest guest);

    void deleteBooking(Booking booking);

    void updateBooking(Booking booking);

    Hotel createHotel(String name, Location location, HotelType hotelType);

    Location createLocation(String name);

    HotelType createHotelType(String hotelTypeName);

    Guest createGuest(String firstName, String surname);
}
