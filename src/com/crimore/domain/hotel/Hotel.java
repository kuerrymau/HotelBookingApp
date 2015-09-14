package com.crimore.domain.hotel;

import com.crimore.domain.location.Location;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-09-13.
 */

@Entity
@javax.persistence.Table(name = "Hotel")
@Inheritance(strategy = InheritanceType.JOINED)
public class Hotel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "grade")
    private String grade;

    @ManyToOne
    @JoinColumn(name = "locatedInID")
    private Location locatedIn;

    @OneToOne
    @JoinColumn(name = "hotelTypeID")
    private HotelType hotelType;

    @Column(name = "checkInTime")
    private Date checkInTime;

    @Column(name = "checkOutTime")
    private Date checkOutTime;

    public Hotel() {
    }

    public Hotel(String grade, Location locatedIn, HotelType hotelType) {
        this.grade = grade;
        this.locatedIn = locatedIn;
        this.hotelType = hotelType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public HotelType getHotelType() {
        return hotelType;
    }

    public void setHotelType(HotelType hotelType) {
        this.hotelType = hotelType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Location getLocatedIn() {
        return locatedIn;
    }

    public void setLocatedIn(Location locatedIn) {
        this.locatedIn = locatedIn;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(description, hotel.description) &&
                Objects.equals(emailAddress, hotel.emailAddress) &&
                Objects.equals(grade, hotel.grade) &&
                Objects.equals(locatedIn, hotel.locatedIn) &&
                Objects.equals(checkInTime, hotel.checkInTime) &&
                Objects.equals(checkOutTime, hotel.checkOutTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, emailAddress, grade, locatedIn, checkInTime, checkOutTime);
    }
}
