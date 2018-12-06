package com.mcknz.abilities;

public class AbilityException extends Exception {
    public AbilityException(Exception ex) {
        this("Unable to add ability to Player", ex);
    }

    public AbilityException(String message, Exception ex) {
        super(message, ex);
    }
}
