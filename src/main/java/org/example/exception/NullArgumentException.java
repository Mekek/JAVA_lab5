package org.example.exception;

/**
 * @author Mikhail Kadilov
 * This is an exception that can be thrown while the program is running.
 */
public class NullArgumentException extends RuntimeException{
    public NullArgumentException() {
        super("нулевой аргумент");
    }

    public NullArgumentException(String message) {
        super(message);
    }
}
