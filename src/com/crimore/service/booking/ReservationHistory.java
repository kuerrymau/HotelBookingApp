package com.crimore.service.booking;

import com.crimore.domain.booking.Booking;
import com.crimore.domain.guest.Guest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cchingwenje on 2015-09-16.
 */
public class ReservationHistory {
    public static List<Booking> reservationsForGuest = new ArrayList<Booking>();

    public List<Booking> getBookingsForGuest(Guest guest) {
        if (guest == null) {
            System.out.print("Please supply a guest.");
        }
        return reservationsForGuest;
    }
}
