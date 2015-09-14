package com.crimore.service.booking.impl;

import com.crimore.domain.booking.Booking;
import com.crimore.domain.entitymanager.EntityManagerImpl;
import com.crimore.domain.guest.Guest;
import com.crimore.domain.hotel.Hotel;
import com.crimore.domain.hotel.HotelType;
import com.crimore.domain.location.Location;
import com.crimore.service.booking.BookingManager;

import javax.persistence.EntityManager;
import java.util.Date;

/**
 * Created by cchingwenje on 2015-09-13.
 */
public class BookingManagerImpl implements BookingManager {

    private EntityManager entityManager = EntityManagerImpl.getEntityManager();

    @Override
    public Booking makeBooking(Hotel hotel, Date arrivalDate, Date departureDate, Guest guest) {
        Booking booking = new Booking(hotel, arrivalDate, departureDate, guest);
        try {
            entityManager.getTransaction().begin();
            booking = entityManager.merge(booking);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return booking;
    }

    @Override
    public void deleteBooking(Booking booking) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(booking);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void updateBooking(Booking booking) {
        try {
            entityManager.getTransaction().begin();
            booking = (Booking) entityManager.find(Booking.class, booking.getId());
            entityManager.merge(booking);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Hotel createHotel(String name, Location location, HotelType hotelType) {
        Hotel hotel = new Hotel("Twos Star", location, hotelType);
        try {
            entityManager.getTransaction().begin();
            hotel = entityManager.merge(hotel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return hotel;
    }

    @Override
    public Location createLocation(String name) {
        Location location = new Location(name);
        try {
            entityManager.getTransaction().begin();
            location = entityManager.merge(location);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return location;
    }

    @Override
    public HotelType createHotelType(String hotelTypeName) {
        HotelType hotelType = new HotelType(hotelTypeName);
        try {
            entityManager.getTransaction().begin();
            hotelType = entityManager.merge(hotelType);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return hotelType;
    }
    @Override
    public Guest createGuest(String firstName, String surname) {
        Guest guest = new Guest(firstName, surname);
        try {
            entityManager.getTransaction().begin();
            guest = entityManager.merge(guest);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return guest;
    }
}
