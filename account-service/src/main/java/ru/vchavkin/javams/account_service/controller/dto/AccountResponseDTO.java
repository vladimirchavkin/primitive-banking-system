package ru.vchavkin.javams.account_service.controller.dto;

import ru.vchavkin.javams.account_service.entity.Account;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public class AccountResponseDTO {

    //Fields
    private Long accountId;

    private String name;

    private String email;

    private String phone;

    private List<Long> bills;

    private OffsetDateTime creationDate;

    // Constructor
    public AccountResponseDTO(Long accountId, String name, String email, String phone, List<Long> bills, OffsetDateTime creationDate) {
        this.accountId = accountId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bills = bills;
        this.creationDate = creationDate;
    }

    // Constructor for GetMapping("{accountId}). getAccountById
    public AccountResponseDTO(Account account) {
        accountId = account.getAccountId();
        name = account.getName();
        email = account.getEmail();
        phone = account.getPhone();
        bills = account.getBills();
        creationDate = account.getCreationDate();
    }

    // Getters
    public Long getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Long> getBills() {
        return bills;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }
}
