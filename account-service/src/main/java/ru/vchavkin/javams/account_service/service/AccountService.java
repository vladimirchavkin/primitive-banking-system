package ru.vchavkin.javams.account_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vchavkin.javams.account_service.entity.Account;
import ru.vchavkin.javams.account_service.exceptions.AccountNotFoundException;
import ru.vchavkin.javams.account_service.repository.AccountRepository;

import java.time.OffsetDateTime;
import java.util.List;


/**
 * @author vladimirchavkinwork@gmail.com
 */

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Create new account
    public Long createAccount(String name, String email, String number, List<Long> bills) {
        Account account = new Account(name, email, number, OffsetDateTime.now(), bills);
        return accountRepository.save(account).getAccountId();
    }

    // Get account by id
    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElseThrow(() ->
                new AccountNotFoundException("Account with id " + accountId + "not found"));
    }

    // Delete account by id
    public void deleteById(Long accountId) {
        try {
            accountRepository.deleteById(accountId);
        } catch (AccountNotFoundException accountNotFoundException) {
            accountNotFoundException.printStackTrace();
        }

    }

    // Update account
    public Account updateAccount(Long accountId, String name, String email, String phone, List<Long> bills) {
        Account account = new Account();
        account.setBills(bills);
        account.setEmail(email);
        account.setName(name);
        account.setPhone(phone);
        return accountRepository.save(account);
    }
}
