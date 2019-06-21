package com.playtika.automation.school.java3.task1.exception;

public class SaladBowlIsFullException extends Exception {

    public SaladBowlIsFullException() {
    }

    public SaladBowlIsFullException(String message) {
        super(message);
    }

    public SaladBowlIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaladBowlIsFullException(Throwable cause) {
        super(cause);
    }
}
