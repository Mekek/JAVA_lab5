package org.example.exception;


/**
 * @author Mikhail Kadilov
 * This is an exception that can be thrown while the program is running.
 */
public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException() {
        super("коллекция пуста ");
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
