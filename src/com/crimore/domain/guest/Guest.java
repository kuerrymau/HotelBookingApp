package com.crimore.domain.guest;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by cchingwenje on 2015-09-13.
 */

@Entity
@Table(name = "Guest")
@Inheritance(strategy = InheritanceType.JOINED)
public class Guest {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(length = 32)
    private String firstName;

    @Column(length = 32)
    private String surname;

    @Column(length = 64)
    private String emailAddress;

    @Column(length = 10)
    private String telephoneNumber;

    private String debitCardNumber;

    private DebitCardType debitCardType;

    private String debitCardName;

    private int debitCardExpiryMonth;

    private int debitCardExpiryYear;

    public Guest(){

    }

    public Guest(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }

    public DebitCardType getDebitCardType() {
        return debitCardType;
    }

    public void setDebitCardType(DebitCardType debitCardType) {
        this.debitCardType = debitCardType;
    }

    public String getDebitCardName() {
        return debitCardName;
    }

    public void setDebitCardName(String debitCardName) {
        this.debitCardName = debitCardName;
    }

    public int getDebitCardExpiryMonth() {
        return debitCardExpiryMonth;
    }

    public void setDebitCardExpiryMonth(int debitCardExpiryMonth) {
        this.debitCardExpiryMonth = debitCardExpiryMonth;
    }

    public int getDebitCardExpiryYear() {
        return debitCardExpiryYear;
    }

    public void setDebitCardExpiryYear(int debitCardExpiryYear) {
        this.debitCardExpiryYear = debitCardExpiryYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(getFirstName(), guest.getFirstName()) &&
                Objects.equals(getSurname(), guest.getSurname()) &&
                Objects.equals(getEmailAddress(), guest.getEmailAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSurname(), getEmailAddress());
    }
}
