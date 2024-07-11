package ru.vchavkin.javams.bill_service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vchavkin.javams.bill_service.entity.Bill;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public interface BillRepository extends CrudRepository<Bill, Long> {
}
