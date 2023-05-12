package org.example.exception;

/**
 * @author Mikhail Kadilov
 * This is an exception that can be thrown while the program is running.
 */
public class WrongTypeException extends RuntimeException{
    public WrongTypeException() {
        super("неверный тип данных у введенного аргумента");
    }

    public WrongTypeException(String message) {
        super(message);
    }
}
