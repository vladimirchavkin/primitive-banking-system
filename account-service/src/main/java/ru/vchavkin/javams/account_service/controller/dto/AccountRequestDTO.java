package ru.vchavkin.javams.account_service.controller.dto;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author vladimirchavkinwork@gmail.com
 */


public class AccountRequestDTO {
    private String name;

    private String email;

    private String phone;

    private List<Long> bills;

    private OffsetDateTime creationDate;

    // Constructor
    public AccountRequestDTO() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public List<Long> getBills() {
        return bills;
    }
}
