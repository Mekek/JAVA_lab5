package org.example.commands;

import org.example.File.Collection;

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
        if (args.length == 1){
            int eventId = Integer.parseInt(args[0]);
            collection.removeAllByEventId(eventId);
        } else {
            System.out.println("Некорректное количество аргументов");
        }
    }
}
