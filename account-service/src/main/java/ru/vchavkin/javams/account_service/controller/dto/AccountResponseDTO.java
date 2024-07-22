package ru.vchavkin.javams.account_service.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.vchavkin.javams.account_service.entity.Account;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@AllArgsConstructor
@Getter
public class AccountResponseDTO {

    //Fields
    private Long accountId;

    private String name;

    private String email;

    private String phone;

    private List<Long> bills;

    private OffsetDateTime creationDate;

    // Constructor for GetMapping({accountId}). getAccountById
    public AccountResponseDTO(Account account) {
        accountId = account.getAccountId();
        name = account.getName();
        email = account.getEmail();
        phone = account.getPhone();
        bills = account.getBills();
        creationDate = account.getCreationDate();
    }

}
