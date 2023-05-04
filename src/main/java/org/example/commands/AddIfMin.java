package org.example.commands;

import org.example.Exception.EmptyCollectionException;
import org.example.File.Collection;
import org.example.model.Ticket;

/**
 * The 'AddIfMin' class is a command that puts element in collection, if it's smaller that the smallest element in collection
 */
public class AddIfMin extends Command{
    private Collection collection;
    public AddIfMin(Collection collection){
        this.collection = collection;
    }

    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        Ticket element = TicketBuilder.create(collection.maxId() + 1);
        collection.addIfMin(element);
    }
}
