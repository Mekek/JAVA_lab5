package org.example.utility;

import org.example.exception.NullArgumentException;
import org.example.commands.Add;
import org.example.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class HelperUtil {
    public static boolean checkInteger(String s) {
        try {
            int a = Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean checkString(String s){
        if (s != null){
            return true;
        }
        return false;
    }

    public static boolean checkLong(String s) {
        try {
            long a = Long.parseLong(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkFloat(String s) {
        try {
            float a = Float.parseFloat(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        String result;
        while (true) {
            String s = scanner.next();
            if (s.equals("null") || s.isEmpty()) {
                System.err.println("данные не могут быть null");
            } else {
                result = s;
                break;
            }
        }
        return result;
    }


        public static long inputLong() {
        Scanner scanner = new Scanner(System.in);
        long result;
        while (true) {
            String s = scanner.next();
            if (checkLong(s)) {
                result = Long.parseLong(s);
                break;
            } else {
                System.err.println("нужен long формат данных");
            }
        }
        return result;
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int result;
        while (true) {
            String s = scanner.next();
            if (checkInteger(s)) {
                result = Integer.parseInt(s);
                break;
            } else {
                System.err.println("нужен int формат данных");
            }
        }
        return result;
    }

    public static float inputFloatY() {
        Scanner scanner = new Scanner(System.in);
        float result;
        while (true) {
            String s = scanner.next();
            if (checkFloat(s)) {
                result = Float.parseFloat(s);
                break;
            } else {
                System.err.println("нужен float формат данных");
            }
        }
        return result;
    }

    public static float inputPrice() {
        Scanner scanner = new Scanner(System.in);
        float result;
        while (true) {
            String s = scanner.next();
            if (checkFloat(s)) {
                if (Float.parseFloat(s)  > 0) {
                    result = Float.parseFloat(s);
                    break;
                }
                else {
                    System.err.println("Цена должна быть больше 0");
                }
            } else {
                System.err.println("нужен float формат данных");
            }
        }
        return result;
    }


    public static TicketType inputEnumConstant() {
        Scanner scanner = new Scanner(System.in);
        TicketType ticketType;
        while (true) {
            String s = scanner.next();

            if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) < TicketType.values().length) {
                ticketType = Add.createTicketType(s);
                break;
            } else {
                System.err.println("введенное число находится вне диапазона");
            }

        }
        return ticketType;
    }


    public static float inputFloatSalary() {
        Scanner scanner = new Scanner(System.in);
        float result;
        while (true) {
            String s = scanner.next();
            if (checkFloat(s)) {
                result = Float.parseFloat(s);
                if (result <= 0) {
                    System.err.println("зарплата должна быть больше нуля)");
                } else {
                    break;
                }
            } else {
                System.err.println("нужен float формат данных");
            }
        }
        return result;
    }

    public static boolean checkData(String data) {
        try {
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(data, formatter2);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static LocalDate inputData() {
        Scanner scanner = new Scanner(System.in);
        LocalDate result;
        while (true) {
            String s = scanner.next();
            if (checkData(s)) {
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                result = LocalDate.parse(s, formatter2);
                break;
            } else {
                System.err.println("некорректная дата");
            }
        }
        return result;
    }
    public static void checkTickets(Long id, String name, Coordinates coordinates, LocalDate creationDate, Float price, TicketType ticketType, Integer eventId, String eventName, LocalDateTime eventDate, Integer minAge){
        if (id == null) throw new NullArgumentException("id не может быть null");
        if (id <= 0) throw new IllegalArgumentException("id не положительный");
        if (Objects.equals(name,"null") || name == null || name.isEmpty() || name.isBlank()) throw new NullArgumentException("имя пустое");
        if (coordinates == null) throw  new NullArgumentException("пустые координаты");
        if (creationDate == null)throw new NullArgumentException("нулевое время");
        if (price <= 0) throw new IllegalArgumentException("стоимость билета <= 0");
        if (ticketType == null) throw new NullArgumentException("некорректный тип билета");
        if (eventId == null) throw new NullArgumentException("id события не может быть null");
        if (eventId <= 0) throw new IllegalArgumentException("id события не положительный");
        if (Objects.equals(eventName,"null") || eventName == null || eventName.isEmpty() || eventName.isBlank()) throw new NullArgumentException("имя события пустое");
        if (eventDate == null)throw new NullArgumentException("нулевое время у события");
        if (minAge <= 0) throw new IllegalArgumentException("минимальный возраст <= 0");
    }

    public static double inputDoubleX() {
        Scanner scanner = new Scanner(System.in);
        double result;
        while (true) {
            String s = scanner.next();
            if (checkDouble(s)) {
                if (Double.parseDouble(s) > -222) {
                    result = Double.parseDouble(s);
                    break;
                }
                else {
                    System.err.println("x-координата должна быть больше -222");
                }
            } else {
                System.err.println("нужен double формат данных");
            }
        }
        return result;
    }

    private static boolean checkDouble(String s) {
        try {
            double a = Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}

