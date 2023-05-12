package org.example.commands;

import org.example.exception.EmptyCollectionException;
import org.example.file.Collection;
import org.example.model.Ticket;

/**
 * @author Mikhail Kadilov
 * The 'AddIfMax' class is a command that puts element in collection, if it's greater that the greatest element in collection
 */
public class AddIfMax extends Command{
    private Collection collection;
    public AddIfMax(Collection collection){
        this.collection = collection;
    }

    /**
     * The function adds a ticket to the collection, if this element higher, the all elements in collections
     */
    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        Ticket element = TicketBuilder.create(collection.maxId() + 1);
        collection.addIfMax(element);
    }
}
