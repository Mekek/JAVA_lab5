package org.example.commands;

import org.example.File.Collection;
import org.example.model.Ticket;

/**
 * The class is used to update the value of the collection element whose id is equal to the given one
 */
public class UpdateId extends Command {
    private Collection collection;

    public UpdateId(Collection collection) {
        this.collection = collection;
    }
/**
 * The function takes an argument, which is the id of the event that will be updated.
 * @params argument The argument that the user entered.
 */
    @Override
    public void execute(String[] args) {
        if (args.length == 1){
            int id = Integer.parseInt(args[0]);
        Ticket ticket =collection.getById(id);
        if (ticket != null){
            TicketBuilder.create(id); //проверить
        }

    } else {
            System.out.println("Некорректное количество аргументов");
        }
    }
}
