package org.example.commands;

import org.example.file.Collection;

/**
 * The 'RemoveAt' class is a command that remove element by its index in collection
 */
public class RemoveAt extends Command{
    private Collection collection;

    public RemoveAt(Collection collection) {
        this.collection = collection;
    }
    /**
     * Remove a ticket from the collection by its position
     */
    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            int index = Integer.parseInt(args[0]);
            if (index <= collection.getSize() && index >= 0) {
                collection.removeAt(index);
            }
            else {
                System.err.println("некорректный индекс");
            }

        } else {
            System.err.println("некорректное количество аргументов");
        }
        if (collection.countElements() == 0){
            System.err.println("коллекция пуста");
        }
    }
}
