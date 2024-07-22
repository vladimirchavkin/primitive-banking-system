package ru.vchavkin.javams.bill_service.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@NoArgsConstructor
@Getter
public class BillRequestDTO {

    // Fields
    private Long accountId;

    private BigDecimal amount;

    private Boolean isDefault;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    private Boolean overdraftEnabled;

}
