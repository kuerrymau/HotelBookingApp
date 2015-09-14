package com.crimore.domain.location;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-09-13.
 */


@Entity
@javax.persistence.Table(name = "Location")
@Inheritance(strategy = InheritanceType.JOINED)
public class Location {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String name;


    public Location() {
    }

    public Location(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(getName(), location.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
