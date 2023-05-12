package org.example.commands;

import org.example.exception.EmptyCollectionException;
import org.example.file.Collection;
import org.example.model.Ticket;
/**
 * The `ShowCommand` class is a command that prints all the elements of the collection in string
 * representation
 */
public class Show extends Command{
    private Collection collection;
    public Show(Collection collection) {
        this.collection=collection;
    }

    /**
     * * Prints all the tickets in the collection
     * @param args the arguments passed to the command.
     */
    @Override
    public void execute(String[] args) {
        if (collection.countElements() == 0) throw new EmptyCollectionException();
        for (Ticket ticket : Collection.getTickets()){
            System.out.println(ticket);
        }
    }
}
