package com.crimore;

import com.crimore.domain.booking.Booking;
import com.crimore.domain.guest.Guest;
import com.crimore.domain.hotel.Hotel;
import com.crimore.domain.hotel.HotelType;
import com.crimore.domain.hotel.RoomType;
import com.crimore.domain.location.Location;
import com.crimore.service.booking.BookingManager;
import com.crimore.service.booking.impl.BookingManagerImpl;
import org.apache.log4j.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

/**
 * Created by cchingwenje on 2015-09-13.
 */
public class JPATest {
    static Logger log = Logger.getLogger(JPATest.class);
    static BookingManager bm = new BookingManagerImpl();

//    @BeforeClass
//    public static void setUpClass() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//
//    }

    @Test
    public void canCreateAndUpdateAndDeleteBooking() {
        log.info("canCreateAndUpdateAndDelete starting ");
        Location durban = bm.createLocation("Durbans");

        HotelType hotelType = bm.createHotelType("Hotels");

        Guest guest = bm.createGuest("Crimores", "Chings");

        Hotel hotel = bm.createHotel("Threes Star", durban, hotelType);

        RoomType roomType = bm.createRoomType("Exclusive Grand", hotel, 5.00f, 2);

        Booking booking = bm.makeBooking(hotel, new Date(), new Date(), guest, roomType);

        assertNotNull("Not found", booking);

        guest.setFirstName("Cremora");

        booking = bm.makeBooking(hotel, new Date(), new Date(), guest, roomType);

        bm.updateBooking(booking);

        assertEquals("Wrong name of guest", "Crimores", booking.getGuest().getFirstName());


        List<RoomType> availableRoomsInLocation = bm.findAvailableRoomsInLocation();
        for (RoomType rt : availableRoomsInLocation) {
            log.info("availableRoomsInLocation=" + rt.getName());
        }

        log.info("canCreateAndUpdateAndDelete completed ");
    }
}
