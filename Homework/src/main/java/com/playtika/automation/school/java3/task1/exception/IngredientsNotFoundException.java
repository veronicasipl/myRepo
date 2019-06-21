package com.playtika.automation.school.java3.task1.exception;

public class IngredientsNotFoundException extends Exception {

    public IngredientsNotFoundException() {
    }

    public IngredientsNotFoundException(String message) {
        super(message);
    }

    public IngredientsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IngredientsNotFoundException(Throwable cause) {
        super(cause);
    }
}
