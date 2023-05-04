package org.example.Exception;

public class EmptyCollectionException extends RuntimeException{
    public EmptyCollectionException() {
        super("коллекция пуста ");
    }

    public EmptyCollectionException(String message) {
        super(message);
    }
}
