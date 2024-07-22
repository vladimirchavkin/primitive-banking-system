package ru.vchavkin.javams.account_service.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author vladimirchavkinwork@gmail.com
 */


@NoArgsConstructor
@Getter
public class AccountRequestDTO {
    private String name;

    private String email;

    private String phone;

    private List<Long> bills;

    private OffsetDateTime creationDate;

}
