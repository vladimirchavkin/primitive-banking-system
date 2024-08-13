package ru.vchavkin.javams.bill_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vchavkin.javams.bill_service.entity.Bill;
import ru.vchavkin.javams.bill_service.exceptions.BillException;
import ru.vchavkin.javams.bill_service.repository.BillRepository;

import java.math.BigDecimal;


/**
 * @author vladimirchavkinwork@gmail.com
 */

@Slf4j
@Service
public class BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    // Create new bill
    public Bill createBill(Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
        log.info("REST request to create bill with: accountId={}, amount={}, isDefault={}, overdraftEnabled={}",
                accountId, amount, isDefault, overdraftEnabled);
        Bill createdBill = new Bill(accountId ,amount, isDefault, overdraftEnabled);
        log.debug("Saved bill: {}", createdBill);
        return billRepository.save(createdBill);
    }

    // Get bill by id
    public Bill getBillById(Long billId) {
        log.info("REST request to get bill with billId: {}", billId);
        return billRepository.findById(billId).orElseThrow(() ->
                new BillException("Bill with id " + billId + "not found."));
    }

    // Delete bill by id
    public Bill deleteById(Long billId) {
        log.info("REST request to delete account with accountId: {}", billId);
        Bill deletedBill = getBillById(billId);
        billRepository.deleteById(billId);
        log.debug("Deleted bill: {}", deletedBill);
        return deletedBill;
    }

    // Update bill
    public Bill updateBill(Long billId ,Long accountId, BigDecimal amount, Boolean isDefault, Boolean overdraftEnabled) {
        log.info("REST request to update bill with: accountId={}, amount={}, isDefault={}, overdraftEnabled={}",
                accountId, amount, isDefault, overdraftEnabled);
        Bill updatedBill = getBillById(accountId);
        updatedBill.setAccountId(accountId);
        updatedBill.setAmount(amount);
        updatedBill.setIsDefault(isDefault);
        updatedBill.setOverdraftEnabled(overdraftEnabled);
        log.debug("Updated bill: {}", updatedBill);
        return updatedBill;
    }
}
