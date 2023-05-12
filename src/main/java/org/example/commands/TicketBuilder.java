package org.example.commands;

import org.example.file.Collection;
import org.example.utility.HelperUtil;
import org.example.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class TicketBuilder{
    public static Ticket create(Integer identifier){
        Scanner scanner = new Scanner(System.in);
        Integer id = identifier;
        System.out.println("Введите имя обладателя билета: ");
        String name = HelperUtil.inputString();
        Coordinates coordinates = createCoordinates();
        LocalDate creationDate = LocalDate.now();
        System.out.println("Введите стоимость билета:");
        Float price = Float.valueOf(scanner.next());
        System.out.println("Выберите тип билета: 0-VIP 1-USUAL 2-BUDGETARY 3-CHEAP");
        int number = scanner.nextInt();
        TicketType ticketType = TicketType.values()[number];
        Event event = createEvent();
        Ticket ticket = new Ticket(id, name, coordinates, creationDate, price, ticketType, event);
        return ticket;
    }
    public static Event createEvent() {
        Scanner scanner = new Scanner(System.in);
//        Integer eventId = identifier;
        System.out.println("Введите название события ");
        String eventName = scanner.nextLine();
        System.out.println("Введите дату события в формате dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Введите минимальный допустимы возраст для участников события");
        Integer minAge = HelperUtil.inputInt();
        Integer eventId = TicketBuilder.makeEventId(eventName, eventDate, minAge);

        return new Event(eventId, eventName, eventDate, minAge);
    }

    public static int makeEventId(String eventName, LocalDate eventDate, Integer minAge) {
        for (Ticket ticket : org.example.file.Collection.getTickets()) {
            if (Objects.equals(ticket.getEvent().getName(), eventName) || ticket.getEvent().getDate() == eventDate || ticket.getEvent().getMinAge() == minAge) {
                return ticket.getEvent().getId();
            }
        }

        // ищем макс значение eventId
        int maxEventId = 0;
        for (Ticket ticket : Collection.getTickets()) {
            if (ticket.getEvent().getId() > maxEventId) {
                maxEventId = ticket.getEvent().getId();
            }
        }

        return maxEventId + 1;
    }


    private static Coordinates createCoordinates(){
        System.out.println("Введите x(double):");
        double x = HelperUtil.inputDoubleX();
        System.out.println("Введите y(float):");
        float y = HelperUtil.inputFloatY();
        return new Coordinates(x,y);
    }

}
