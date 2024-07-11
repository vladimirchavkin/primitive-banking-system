package ru.vchavkin.javams.bill_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vchavkin.javams.bill_service.controller.dto.BillRequestDTO;
import ru.vchavkin.javams.bill_service.controller.dto.BillResponseDTO;
import ru.vchavkin.javams.bill_service.service.BillService;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    // Get bill by id
    @GetMapping("/{billId}")
    public BillResponseDTO getBillById(@PathVariable Long billId) {
        return new BillResponseDTO(billService.getBillById(billId));
    }

    // Create bill
    @PostMapping("/")
    public Long createBill(@RequestBody BillRequestDTO billRequestDTO) {
        return billService.createBill(billRequestDTO.getAccountId(), billRequestDTO.getAmount(),
                billRequestDTO.getDefault(), billRequestDTO.getCreationDate(), billRequestDTO.getOverdraftEnabled());
    }

    // Delete bill
    @DeleteMapping("/{billId}")
    public BillResponseDTO deleteBill(@PathVariable Long billId) {
        return new BillResponseDTO(billService.deleteById(billId));
    }

    // Update bill
    @PutMapping("/{billId}")
    public BillResponseDTO updateBill(@PathVariable Long billId,
                                      @RequestBody BillRequestDTO billRequestDTO) {
        return new BillResponseDTO(billService.updateBill(billId, billRequestDTO.getAccountId(), billRequestDTO.getAmount(),
                billRequestDTO.getDefault(), billRequestDTO.getOverdraftEnabled()));
    }
}
