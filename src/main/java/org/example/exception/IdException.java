package org.example.exception;

/**
 * @author Mikhail Kadilov
 * This is an exception that can be thrown while the program is running.
 */
public class IdException extends  RuntimeException{
    public IdException() {
        super("повторяющийся id элементов");
    }

    public IdException(String message) {
        super(message);
    }
}
