package ru.vchavkin.javams.bill_service.exceptions;

/**
 * @author vladimirchavkinwork@gmail.com
 */

public class BillException extends RuntimeException{
    public BillException(String message) {
        super(message);
    }
}
