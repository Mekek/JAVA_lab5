package org.example.file;

import org.example.model.Event;
import org.example.model.Ticket;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;

/**
 * @author Mikhail Kadilov
 * The CollectionManager class manages the collection of all the collections
 * in the application
 */
public class Collection {
    private static Vector<Ticket> tickets;
    private LocalDate dateSave;
    private FileManager fileManager;
    public LocalDate getDateSave() {
        return dateSave;
    }

    /**
     * Saves collection
     */
    public void save(){
        dateSave = LocalDate.now();
        fileManager.save(tickets);
    }
    public void saveAs(String fileName){
        FileManager fileManager1 = new FileManager(fileName);
        fileManager1.save(tickets);
    }

    private LocalDateTime dateInit;
    public Collection(FileManager fileManager) throws FileNotFoundException {
        this.tickets = fileManager.readFile();
        dateInit = LocalDateTime.now();
        this.fileManager = fileManager;
    }
    /**
     * Get the creation date of the object
     * @return The creation date of the collection.
 */
    public LocalDateTime getDateInit() {
        return dateInit;
    }
    /**
     * This function returns the collection of tickets
     * @return The Vector of Tickets objects.
     */
    public static Vector<Ticket> getTickets(){
        return tickets;
    }

    public void add(Ticket ticket){
        tickets.add(ticket);
    }
    public String getType(){
        return tickets.getClass().getName();
    }
    public void clear(){
        tickets.clear();
    }

    /**
     * Returns ticket from collection by its id
     */
    public Ticket getById(long id){
        for (Ticket ticket : tickets){
            if (ticket.getId() == id){
                return ticket;
            }
        }
        return null;
    }

    /**
     * Returns ticket form collection by its price
     */
    public Ticket getByPrice(Integer price){
        for (Ticket ticket : tickets){
            if (Objects.equals(ticket.getPrice(), price)){
                return ticket;
            }
        }
        return null;
    }

    /**
     * Removes element from collection by its id
     */
    public void removeById(long id) {
        ArrayList<Ticket> ticketArrayList = new ArrayList<>(tickets);
        for (int i = 0; i < ticketArrayList.size(); ++i) {
            if (ticketArrayList.get(i).getId() == id) {
                ticketArrayList.remove(i);
            }
        }
        tickets = new Vector<>(ticketArrayList);
    }

    /**
     * Returns max ticket id from collection
     */
    public int maxId(){
        if (tickets.isEmpty()){
            return 0;
        }
        return tickets.stream().max(Comparator.comparing(Ticket::getId)).get().getId();
    }

    /**
     * Adds element to collection if it higher than the highest element in collection
     */
    public void addIfMax(Ticket ticket){
        Ticket maxTicket = tickets.get(0);
        for (Ticket anotherTicket : tickets){
            if (anotherTicket.compareTo(maxTicket) == 1){
                maxTicket = anotherTicket;
            }
        }
        if (ticket.compareTo(maxTicket) == 1) {
            tickets.add(ticket);
        }
    }

    /**
     * Adds element to collection if it lower than the highest element in collection
     */
    public void addIfMin(Ticket ticket){
        Ticket minTicket = tickets.get(0);
        for (Ticket anotherTicket : tickets){
            if (anotherTicket.compareTo(minTicket) < 0){
                minTicket = anotherTicket;
            }
        }
        if (ticket.compareTo(minTicket) < 0) {
            tickets.add(ticket);
        }
    }

    public int countElements(){
        return tickets.size();
    }

    public void removeAt(int index){
        tickets.remove(index);
    }

    public ArrayList<Event> getEvent(){
        ArrayList<Event> events = new ArrayList<>();
        for (Ticket ticket : tickets){
            if (!events.contains(ticket.getEvent())){
                events.add(ticket.getEvent());
            }
        }
        return events;
    }

    /**
     * Removes tickets from collection by event
     */
    public void removeAllByEvent(Event event) {
        tickets.removeIf(ticket -> (ticket.getEvent().getId() == event.getId()));
    }

    /**
     * Returns amount of tickets from collection with same price
     */
    public int CountByPrice(float price) {
        int counter = 0;
        for (Ticket ticket : tickets){
            if (ticket.getPrice() == price){
                counter ++;
            }
        }
        return counter;
    }
}
