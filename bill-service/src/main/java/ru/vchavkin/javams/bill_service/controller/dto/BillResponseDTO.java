package ru.vchavkin.javams.bill_service.controller.dto;

import ru.vchavkin.javams.bill_service.entity.Bill;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public class BillResponseDTO {

    //Fields
    private Long billId;
    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationDate;

    private Boolean overdraftEnabled;

    // Constructors
    public BillResponseDTO(Long accountId, BigDecimal amount, Boolean isDefault, OffsetDateTime creationDate, Boolean overdraftEnabled) {
        this.accountId = accountId;
        this.amount = amount;
        this.isDefault = isDefault;
        this.creationDate = creationDate;
        this.overdraftEnabled = overdraftEnabled;
    }

    // Constructor for GetMapping("{billId}). getBillById
    public BillResponseDTO(Bill bill) {
        billId = bill.getBillId();
        accountId = bill.getAccountId();
        amount = bill.getAmount();
        isDefault = bill.getDefault();
        creationDate = bill.getCreationDate();
        overdraftEnabled = bill.getOverdraftEnabled();
    }

    // Getters
    public Long getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public OffsetDateTime getCreationDate() {
        return creationDate;
    }

    public Boolean getOverdraftEnabled() {
        return overdraftEnabled;
    }
}
