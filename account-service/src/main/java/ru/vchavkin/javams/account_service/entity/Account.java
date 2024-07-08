package ru.vchavkin.javams.account_service.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Entity
public class Account {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String name;

    private String email;

    private String phone;

    private OffsetDateTime creationDate;

    @ElementCollection
    private List<Long> bills;

    // To String
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", creationDate=" + creationDate +
                ", bills=" + bills +
                '}';
    }

    // Constructors
    public Account(String name, String email, String phone, OffsetDateTime creationDate, List<Long> bills) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.creationDate = creationDate;
        this.bills = bills;
    }

    public Account() {
    }

    // Getters & Setters
    public Long getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<Long> getBills() {
        return bills;
    }

    public void setBills(List<Long> bills) {
        this.bills = bills;
    }
}
