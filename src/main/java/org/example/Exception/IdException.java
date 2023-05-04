package org.example.Exception;

public class IdException extends  RuntimeException{
    public IdException() {
        super("повторяющийся id элементов");
    }

    public IdException(String message) {
        super(message);
    }
}
