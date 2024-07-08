package ru.vchavkin.javams.account_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vchavkin.javams.account_service.controller.dto.AccountRequestDTO;
import ru.vchavkin.javams.account_service.controller.dto.AccountResponseDTO;
import ru.vchavkin.javams.account_service.service.AccountService;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Get by id
    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccountById(@PathVariable Long accountId) {
        return new AccountResponseDTO(accountService.getAccountById(accountId));
    }

    // Create account
    @PostMapping("/")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(accountRequestDTO.getName(), accountRequestDTO.getEmail(),
                accountRequestDTO.getPhone(), accountRequestDTO.getBills());
    }

    // Delete account by id
    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        accountService.deleteById(accountId);
    }

    // Update account
    @PutMapping("/{accountId}")
    public AccountResponseDTO updateAccount(@PathVariable Long accountId,
                                            @RequestBody AccountRequestDTO accountRequestDTO) {
        return new AccountResponseDTO(accountService.updateAccount(accountId, accountRequestDTO.getName(), accountRequestDTO.getEmail(),
                accountRequestDTO.getPhone(), accountRequestDTO.getBills()));
    }


}
