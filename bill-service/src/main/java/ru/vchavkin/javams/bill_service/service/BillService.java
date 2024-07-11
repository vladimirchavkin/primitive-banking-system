package ru.vchavkin.javams.bill_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ru.vchavkin.javams.bill_service.entity.Bill;
import ru.vchavkin.javams.bill_service.exceptions.BillNotFoundException;
import ru.vchavkin.javams.bill_service.repository.BillRepository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author vladimirchavkinwork@gmail.com
 */


@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBillById(@PathVariable Long billId) {
        return billRepository.findById(billId).orElseThrow(() ->
                new BillNotFoundException("Bill with id " + billId + "not found"));
    }

    public Long createBill(Long accountId, BigDecimal amount, Boolean isDefault, OffsetDateTime creationDate, Boolean overdraftEnabled) {
        Bill bill = new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overdraftEnabled);
        return billRepository.save(bill).getBillId();
    }

    public Bill updateBill(Long billId, Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
        Bill bill = new Bill(accountId, amount, isDefault, overdraftEnabled);
        bill.setBillId(billId);
        return billRepository.save(bill);
    }

    // Delete bill by id
    public Bill deleteById(Long billId) {
        Bill deletedBill = getBillById(billId);
        billRepository.deleteById(billId);
        return deletedBill;
    }
}
