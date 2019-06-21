package com.playtika.automation.school.java3.task1.exception;

public class IngredientDataIsInvalidException extends Exception {

    public IngredientDataIsInvalidException() {
    }

    public IngredientDataIsInvalidException(String message) {
        super(message);
    }

    public IngredientDataIsInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public IngredientDataIsInvalidException(Throwable cause) {
        super(cause);
    }
}
