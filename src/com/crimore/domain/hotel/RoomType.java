package com.crimore.domain.hotel;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-09-13.
 */

@Entity
@Table(name = "RoomType")
@Inheritance(strategy = InheritanceType.JOINED)
public class RoomType {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hotelID")
    private Hotel hotel;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "roomRatePerDay")
    private float roomRatePerDay;

    @Lob
    @Column(nullable = false)
    private String description = "";

    @Column(name = "maxNumberOfPeople")
    private int maxNumberOfPeople = 2;

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

    public float getRoomRatePerDay() {
        return roomRatePerDay;
    }

    public void setRoomRatePerDay(float roomRatePerDay) {
        this.roomRatePerDay = roomRatePerDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomType)) return false;
        RoomType roomType = (RoomType) o;
        return Objects.equals(maxNumberOfPeople, roomType.maxNumberOfPeople) &&
                Objects.equals(hotel, roomType.hotel) &&
                Objects.equals(name, roomType.name) &&
                Objects.equals(description, roomType.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, name, description, maxNumberOfPeople);
    }
}
