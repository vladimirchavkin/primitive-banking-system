package ru.vchavkin.javams.account_service.exceptions;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message) {
        super(message);
    }
}
