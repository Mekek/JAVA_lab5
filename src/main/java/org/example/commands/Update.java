package org.example.commands;

import org.example.file.Collection;
import org.example.model.Ticket;

/**
 * @author Mikhail Kadilov
 * The class is used to update the value of the collection element whose id is equal to the given one
 */
public class Update extends Command {
    private Collection collection;

    public Update(Collection collection) {
        this.collection = collection;
    }
    /**
     * The function takes an argument, which is the id of the event that will be updated.
     * @param args id of ticket in collection.
     */
    @Override
    public void execute(String[] args) {
        if (args.length == 1){
            int id = Integer.parseInt(args[0]);
        Ticket ticket = collection.getById(id);
        if (ticket != null){
            Ticket ticket1 = TicketBuilder.create(id);
            ticket.setName(ticket1.getName());
            ticket.setCoordinates(ticket1.getCoordinates());
            ticket.setPrice(ticket1.getPrice());
            ticket.setType(ticket1.getType());
            ticket.setEvent(ticket1.getEvent());
        }

        } else {
                System.out.println("Некорректное количество аргументов");
            }
        }
}
