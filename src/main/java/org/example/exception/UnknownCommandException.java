package org.example.exception;

/**
 * @author Mikhail Kadilov
 * This is an exception that can be thrown while the program is running.
 */
public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException() {
        super("некорректная команда");
    }

    public UnknownCommandException(String message) {
        super(message);
    }
}
