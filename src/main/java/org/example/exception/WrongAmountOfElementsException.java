package org.example.exception;

/**
 * @author Mikhail Kadilov
 * This is an exception that can be thrown while the program is running.
 */
public class WrongAmountOfElementsException extends RuntimeException{
    public WrongAmountOfElementsException() {
        super("неверное количество аргументов команды");
    }

    public WrongAmountOfElementsException(String message) {
        super(message);
    }
}
