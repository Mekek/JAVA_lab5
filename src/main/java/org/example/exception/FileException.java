package org.example.exception;

/**
 * @author Mikhail Kadilov
 * This is an exception that can be thrown while the program is running.
 */
public class FileException extends Exception{
    public FileException() {
    }

    public FileException(String message) {
        super(message);
    }
}
