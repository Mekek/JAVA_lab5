package org.example.commands;

import org.example.exception.WrongAmountOfElementsException;
import org.example.file.Collection;
import org.example.model.Event;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Mikhail Kadilov
 *  The 'PrintFieldAscendingEvent' class is a command that prints all event.
 */
public class PrintFieldAscendingEvent extends Command {
    private Collection collection;

    public PrintFieldAscendingEvent(Collection collection) {
        this.collection = collection;
    }

    /**
     * prints events in ascending order
     */
    @Override
    public void execute(String[] args) {
        if (!(args.length < 1)) throw new WrongAmountOfElementsException();
        ArrayList<Event> events = new ArrayList<>(collection.getEvent());
        Collections.sort(events);
        for(Event event : events){
            System.out.println(event.toString());
        }
    }
}
