package com.crimore.domain.hotel;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-09-13.
 */


@Entity
@Table(name = "HotelType")
@Inheritance(strategy = InheritanceType.JOINED)
public class HotelType {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public HotelType() {
    }

    public HotelType(String name) {
        this.name = name;
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

    public void setName(String hotelType) {
        this.name = hotelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelType)) return false;
        HotelType hotelType1 = (HotelType) o;
        return Objects.equals(getName(), hotelType1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
