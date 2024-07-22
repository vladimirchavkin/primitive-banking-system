package ru.vchavkin.javams.account_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Remove;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.List;


/**
 * @author vladimirchavkinwork@gmail.com
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Account {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String phone;

    @CreationTimestamp
    private OffsetDateTime creationDate;

    @NonNull
    @ElementCollection
    private List<Long> bills;

}
