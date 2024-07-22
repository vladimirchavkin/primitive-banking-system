package ru.vchavkin.javams.bill_service.controller.dto;

import lombok.*;
import ru.vchavkin.javams.bill_service.entity.Bill;


import java.math.BigDecimal;
import java.time.OffsetDateTime;


/**
 * @author vladimirchavkinwork@gmail.com
 */

@AllArgsConstructor
@Getter
public class BillResponseDTO {

    //Fields
    private Long billId;

    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private Boolean overdraftEnabled;

    // Constructor for GetMapping({billId}). getBillById
    public BillResponseDTO(Bill bill) {
        billId = bill.getBillId();
        accountId = bill.getAccountId();
        amount = bill.getAmount();
        isDefault = bill.getIsDefault();
        createdAt = bill.getCreatedAt();
        updatedAt = bill.getUpdatedAt();
        overdraftEnabled = bill.getOverdraftEnabled();
    }

}
