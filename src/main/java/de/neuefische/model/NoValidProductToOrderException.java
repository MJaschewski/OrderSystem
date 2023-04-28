package de.neuefische.model;

public class NoValidProductToOrderException extends Exception{

    public NoValidProductToOrderException(String message) {
        super(message);
    }
}
