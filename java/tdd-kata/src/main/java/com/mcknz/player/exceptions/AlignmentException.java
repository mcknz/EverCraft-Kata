package com.mcknz.player.exceptions;

public class AlignmentException extends Exception {
    public AlignmentException(Exception ex) {
        this("Unable to set alignment to Player", ex);
    }

    public AlignmentException(String message) {
        super(message);
    }

    public AlignmentException(String message, Exception ex) {
        super(message, ex);
    }
}
