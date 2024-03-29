package org.example.commands;

import org.example.exception.WrongAddArgumentException;
import org.example.exception.WrongTypeException;
import org.example.file.Collection;
import org.example.utility.HelperUtil;
import org.example.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Mikhail Kadilov
 * The class is responsible for adding a ticket to the collection
 */
public class Add extends Command{
    private Collection collection;
    public Add(Collection collection) {
        this.collection = collection;
    }
    /**
     * The function adds a ticket to the collection
     */
    @Override
    public void execute(String[] args) {
//        System.out.println("Argument count: " + args.length);
//        for (int i = 0; i < args.length; i++) {
//            System.out.println("Argument " + i + ": " + args[i]);
//        }
//        System.out.println(args[0].split(";").length);
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            Integer id = collection.maxId() + 1;
            System.out.println("Введите имя обладателя билета: ");
            String name = HelperUtil.inputString();
            Coordinates coordinates = createCoordinates();
            LocalDate creationDate = LocalDate.now();
            System.out.println("Введите стоимость билета:");
            Float price = HelperUtil.inputPrice();
            System.out.println("Выберите тип билета: 0-VIP 1-USUAL 2-BUDGETARY 3-CHEAP");
            TicketType ticketType = HelperUtil.inputEnumConstant();
            Event event = createEvent();
            Ticket ticket = new Ticket(id, name, coordinates, creationDate, price, ticketType, event);

            ticket.getEvent().setId(TicketBuilder.makeEventId(event.getName(), event.getDate(), event.getMinAge()));
            collection.add(ticket);
        } else if (args[0].split(";").length == 8) {

            String[] params = args[0].split(";");

            Integer id = collection.maxId() + 1;

            String name = params[0];

            double x = Double.parseDouble(params[1]);

            if (x <= -222) throw new WrongAddArgumentException();
            float y = Float.parseFloat(params[2]);

            Coordinates coordinates = new Coordinates(x,y);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate creationDate = LocalDate.now();
            Float price = Float.valueOf(params[3]);

            if (price < 0) throw new WrongAddArgumentException();
            TicketType ticketType = createTicketType(params[4]);
            boolean typeFlag = false;
            for (TicketType ticketType1 : TicketType.values()) {
                if (ticketType1 == ticketType) {
                    typeFlag = true;
                }
            }
            if (!typeFlag) throw new WrongAddArgumentException();

            String eventName = params[5];
            if (params[5].isEmpty() || params[5].equals("null")) throw new WrongTypeException("билет не может быть null или пустым");
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate eventDate = LocalDate.parse(params[6], formatter);
            int minAge = Integer.parseInt(params[7]);
            int eventId = TicketBuilder.makeEventId(eventName, eventDate, minAge);
            if (minAge <= 0 ) throw new WrongTypeException("minAge должен быть положительным");

            Event event = new Event(eventId, eventName, eventDate, minAge);
            Ticket ticket = new Ticket(id, name, coordinates, creationDate, price, ticketType, event);;
            ticket.getEvent().setId(TicketBuilder.makeEventId(event.getName(), event.getDate(), event.getMinAge()));
            collection.add(ticket);

        } else {
            System.err .println("Неверное количество аргументов");

        }
    }

    /**
     * The function returns an event object
     */
    private Event createEvent() {
        Scanner scanner = new Scanner(System.in);
        Integer eventId = 0;

        System.out.println("Введите название события ");
        String eventName = scanner.nextLine();
        System.out.println("Введите дату события в формате dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Введите минимальный допустимы возраст для участников события");
        int minAge = HelperUtil.inputInt();

        return new Event(eventId, eventName, eventDate, minAge);
    }

    /**
     * The function returns coordinates object
     */
    private Coordinates createCoordinates(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x(double):");
        double x = HelperUtil.inputDoubleX();
        System.out.println("Введите y(float):");
        float y = HelperUtil.inputFloatY();
        return new Coordinates(x,y);
    }

    /**
     * The function returns ticketType object
     */
    public static TicketType createTicketType(String s){
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
