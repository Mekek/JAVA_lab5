package org.example.commands;

import org.example.exception.EmptyCollectionException;
import org.example.file.Collection;
import org.example.model.Event;

/**
 * The 'RemoveAllByEventId' class is a command that
 */
public class RemoveAllByEvent extends Command{
    private Collection collection;

    public RemoveAllByEvent(Collection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        Event event = TicketBuilder.createEvent();
        event.setId(TicketBuilder.makeEventId(event.getName(), event.getDate(), event.getMinAge()));
        collection.removeAllByEvent(event);
    }
}
