package ru.vchavkin.javams.bill_service.exceptions;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public class BillNotFoundException extends RuntimeException{
    public BillNotFoundException(String message) {
        super(message);
    }
}
