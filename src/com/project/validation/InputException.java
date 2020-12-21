package com.project.validation;

public class InputException extends RuntimeException {

    private String errorMessage;

    public InputException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}