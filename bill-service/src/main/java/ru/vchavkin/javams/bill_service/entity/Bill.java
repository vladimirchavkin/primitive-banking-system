package ru.vchavkin.javams.bill_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Bill {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;

    @NonNull
    private Long accountId;

    @NonNull
    private BigDecimal amount;

    @NonNull
    private Boolean isDefault;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @NonNull
    private Boolean overdraftEnabled;

}
