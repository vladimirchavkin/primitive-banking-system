package ru.vchavkin.javams.account_service.exceptions;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public class AccountException extends RuntimeException{
    public AccountException(String message) {
        super(message);
    }
}
