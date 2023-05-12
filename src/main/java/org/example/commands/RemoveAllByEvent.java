package org.example.commands;

import org.example.exception.EmptyCollectionException;
import org.example.file.Collection;
import org.example.model.Event;

/**
 * @author Mikhail Kadilov
 * The 'RemoveAllByEventId' class is a command that removes all tickets by event
 */
public class RemoveAllByEvent extends Command{
    private Collection collection;

    public RemoveAllByEvent(Collection collection) {
        this.collection = collection;
    }

    /**
     * Removes all tickets in collection with same event
     */
    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        Event event = TicketBuilder.createEvent();
        event.setId(TicketBuilder.makeEventId(event.getName(), event.getDate(), event.getMinAge()));
        collection.removeAllByEvent(event);
    }
}
