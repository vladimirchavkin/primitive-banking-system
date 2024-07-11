package ru.vchavkin.javams.bill_service.controller.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public class BillRequestDTO {

    // Fields
    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime creationDate;

    private Boolean overdraftEnabled;

    // Constructor
    public BillRequestDTO() {
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
