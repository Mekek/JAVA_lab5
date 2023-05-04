package org.example.commands;

import org.example.Exception.WrongTypeException;
import org.example.File.Collection;
import org.example.Util.HelperUtil;
import org.example.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * The class is responsible for adding an organization to the collection
 */
public class Add extends Command{
    private Collection collection;
    public Add(Collection collection) {
        this.collection = collection;
    }
    /**
     * The function adds an organization to the collection
     */
    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            Integer id = collection.maxId() + 1;
            System.out.println("Введите имя обладателя билета: ");
            String name = HelperUtil.inputString();
            Coordinates coordinates = createCoordinates();
            LocalDate creationDate = LocalDate.now();
            System.out.println("Введите стоимость билета:");
            Integer price = Integer.valueOf(scanner.next());
            System.out.println("Выберите тип билета: 0-VIP 1-USUAL 2-BUDGETARY 3-CHEAP");
            String number = scanner.next();
            TicketType ticketType = createTicketType(number);
            Event event = createEvent();
            Ticket ticket = new Ticket(id, name, coordinates, creationDate, price, ticketType, event);
            collection.add(ticket);
        }
        else {
            String[] params = args[0].split(";");

            Integer id = collection.maxId() + 1;
//            Integer id = Integer.valueOf(params[0]);
//            if (id <= 0 ) throw new WrongTypeException("id должен быть положительным");
//            if (collection.getById(id) != null){
//                throw new IdException();
//            }
            //if (params[1].isEmpty() || params[1].equals("null")) throw new WrongTypeException();
            String name = params[1];
            double x = Double.parseDouble(params[2]);
            float y = Float.parseFloat(params[3]);
            Coordinates coordinates = new Coordinates(x,y);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate creationDate = LocalDate.parse(params[4], formatter);
            Integer price = Integer.valueOf(params[5]);
            TicketType ticketType = createTicketType(params[6]);

            Integer eventId = collection.maxId() + 1;
            String eventName = params[7];
            if (params[7].isEmpty() || params[7].equals("null")) throw new WrongTypeException("билет не может быть null или пустым");
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate eventDate = LocalDate.parse(params[8], formatter);
            Integer minAge = Integer.valueOf(params[9]);
            if (minAge <= 0 ) throw new WrongTypeException("minAge должен быть положительным");

            Event event = new Event(eventId, eventName, eventDate, minAge);
            Ticket ticket = new Ticket(id, name, coordinates, creationDate, price, ticketType, event);
            collection.add(ticket);
        }
    }

    private Event createEvent() {
        Scanner scanner = new Scanner(System.in);
        Integer eventId = collection.maxId() + 1;
        System.out.println("Введите название события ");
        String eventName = scanner.nextLine();
        System.out.println("Введите дату события в формате dd-MM-yyyy HH:mm");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Введите минимальный допустимы возраст для участников события");
        Integer minAge = HelperUtil.inputInt();

        return new Event(eventId, eventName, eventDate, minAge);
    }

    private Coordinates createCoordinates(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x, y");
        float x = HelperUtil.inputFloat();
        long y = HelperUtil.inputLong();
        return new Coordinates(x,y);
    }
    private TicketType createTicketType(String s){
        TicketType ticketType;
        if (s.equals("null")){
            System.err.println("значение не может быть null");
        }
        if (HelperUtil.checkInteger(s)){
            int number = Integer.parseInt(s);
            ticketType = TicketType.values()[number];
        } else {
            ticketType = TicketType.valueOf(s);
        }
        return ticketType;
    }
}
