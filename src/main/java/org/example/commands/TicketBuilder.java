package org.example.commands;

import org.example.Util.HelperUtil;
import org.example.model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        Integer price = Integer.valueOf(scanner.next());
        System.out.println("Выберите тип билета: 0-VIP 1-USUAL 2-BUDGETARY 3-CHEAP");
        int number = scanner.nextInt();
        TicketType ticketType = TicketType.values()[number];
        Event event = createEvent(identifier);
        Ticket ticket = new Ticket(id, name, coordinates, creationDate, price, ticketType, event);
        return ticket;
    }
    private static Event createEvent(Integer identifier) {
        Scanner scanner = new Scanner(System.in);
        Integer eventId = identifier;
        System.out.println("Введите название события ");
        String eventName = scanner.nextLine();
        System.out.println("Введите дату события в формате dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Введите минимальный допустимы возраст для участников события");
        Integer minAge = HelperUtil.inputInt();

        return new Event(eventId, eventName, eventDate, minAge);
    }


    private static Coordinates createCoordinates(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x, y");
        float x = scanner.nextFloat();
        long y = scanner.nextLong();
        return new Coordinates(x,y);
    }

}
