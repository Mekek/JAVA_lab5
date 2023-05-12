package org.example.commands;

import org.example.file.Collection;
import org.example.model.Ticket;

/**
 * The 'RemoveById' class is command that remove an ticket from the collection
 */
public class RemoveById extends Command{
    private Collection collection;

    public RemoveById(Collection collection) {
        this.collection = collection;
    }
    /**
     * Remove an ticket from the collection
     */
    @Override
    public void execute(String[] args) {
            if (args.length == 1) {
                int id = Integer.parseInt(args[0]);
                Ticket ticket = collection.getById(id);
                if (ticket != null) {
                    collection.removeById(id);
                }
            } else {
                System.err.println("некорректное количество аргументов");
            }
            if (collection.countElements() == 0){
                System.err.println("коллекция пуста");
        }
    }
}
