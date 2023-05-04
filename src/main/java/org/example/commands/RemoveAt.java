package org.example.commands;

import org.example.File.Collection;
import org.example.model.Ticket;

/**
 * The 'RemoveFirst' class is a command that remove first element
 */
public class RemoveAt extends Command{
    private Collection collection;

    public RemoveAt(Collection collection) {
        this.collection = collection;
    }
    /**
     * Remove an organization from the collection
     */
    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            int index = Integer.parseInt(args[0]);
            if (index <= collection.getSize() || index >= 0) {
                collection.removeAt(index);
            }
            System.err.println("некорректный индекс");
//            Ticket ticket = collection.getById(id);
//            if (ticket != null) {
//                collection.remove(index);
//            }
        } else {
            System.err.println("некорректное количество аргументов");
        }
        if (collection.countElements() == 0){
            System.err.println("коллекция пуста");
        }
    }
}
