package org.example.exception;


/**
 * @author Mikhail Kadilov
 * This is an exception that can be thrown while the program is running.
 */
public class WrongAddArgumentException extends RuntimeException{
    public WrongAddArgumentException() {
        super("введены неверные аргументы для команды add");
    }

    public WrongAddArgumentException(String message) {
        super(message);
    }
}