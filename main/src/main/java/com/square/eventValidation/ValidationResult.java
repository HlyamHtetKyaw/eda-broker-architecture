package com.square.eventValidation;

public class ValidationResult {
    public final boolean isValid;
    public final String errorMessage;

    public ValidationResult(boolean isValid, String errorMessage){
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    public static ValidationResult success(){
        return new ValidationResult(true,null);
    }

    public static ValidationResult error(String message){
        return new ValidationResult(false,message);
    }
}
