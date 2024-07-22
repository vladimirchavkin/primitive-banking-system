package ru.vchavkin.javams.account_service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vchavkin.javams.account_service.entity.Account;
import ru.vchavkin.javams.account_service.exceptions.AccountException;
import ru.vchavkin.javams.account_service.repository.AccountRepository;

import java.util.List;


/**
 * @author vladimirchavkinwork@gmail.com
 */

@Slf4j
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Create new account
    public Long createAccount(String name, String email, String phone, List<Long> bills) {
        log.info("REST request to create account with: name={}, email={}, phone={}, bills={}",
                name, email, phone, bills);
        Account createdAccount = new Account(name, email, phone, bills);
        log.debug("Saved account: {}", createdAccount);
        return accountRepository.save(createdAccount).getAccountId();
    }

    // Get account by id
    public Account getAccountById(Long accountId) {
        log.info("REST request to get account with accountId: {}", accountId);
        return accountRepository.findById(accountId).orElseThrow(() ->
                new AccountException("Account with id " + accountId + "not found."));
    }

    // Delete account by id
    public Account deleteById(Long accountId) {
        log.info("REST request to delete account with accountId: {}", accountId);
        Account deletedAccount = getAccountById(accountId);
        accountRepository.deleteById(accountId);
        log.debug("Deleted account: {}", deletedAccount);
        return deletedAccount;
    }

    // Update account
    public Account updateAccount(Long accountId, String name, String email, String phone, List<Long> bills) {
        log.info("REST request to update account with: accountId={}, name={}, email={}, number={}, bills={}",
                accountId, name, email, phone, bills);
        Account updatedAccount = getAccountById(accountId);
        updatedAccount.setName(name);
        updatedAccount.setEmail(email);
        updatedAccount.setPhone(phone);
        updatedAccount.setBills(bills);
        log.debug("Updated account: {}", updatedAccount);
        return updatedAccount;
    }
}
