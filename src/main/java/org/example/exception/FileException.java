package org.example.exception;

public class FileException extends Exception{
    public FileException() {
    }

    public FileException(String message) {
        super(message);
    }
}