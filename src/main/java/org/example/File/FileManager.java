package org.example.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.DataAdapter.DateAdapter;
import org.example.Exception.IdException;
import org.example.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;

public class FileManager {
    private String fileName;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public Vector<Ticket> readFile() throws FileNotFoundException {
        Vector<Ticket> tickets = new Vector<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                if (!bufferedReader.ready()){
            } else {
                while ((line = bufferedReader.readLine()) != null) {
                 stringBuilder.append(line);
                }
                Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateAdapter()).create();
                var collectionType = new TypeToken<Vector<Ticket>>() {}.getType();
                    tickets = gson.fromJson(stringBuilder.toString(), collectionType);}
            }  catch (Exception e) {
            throw new RuntimeException(e);
            }
        if (!checkTicketId(tickets)){
            tickets.clear();
            //System.err.println("одинаковые id элементов");
            throw new IdException();
        }
        boolean check = true;

//        System.out.println("cringe_start");
//        Integer maxEventId = 0;
        for (Ticket ticket : tickets){
            if (ticket.getEvent().getId() == 0) {
                ticket.makeEventId(ticket, tickets);

//                for (Ticket ticket1 : tickets) {
//                    if (Objects.equals(ticket1.getEvent().getName(), ticket.getEvent().getName()) || Objects.equals(ticket1.getEvent().getDate(), ticket.getEvent().getDate()) || Objects.equals(ticket1.getEvent().getMinAge(), ticket.getEvent().getMinAge())) {
//                        ticket.getEvent().setId(ticket1.getEvent().getId());
//                        break;
//                    }
//                }
//
//                if (ticket.getEvent().getId() == 0) {
//                    // ищем макс значение eventId
//                    for (Ticket ticket1 : tickets) {
//                        if (ticket1.getEvent().getId() > maxEventId) {
//                            maxEventId = ticket1.getEvent().getId();
//                        }
//                    }
//
//                    ticket.getEvent().setId(maxEventId + 1);
//                }
            }




            ticket.checkTicket();
        }
//        System.out.println("cringe_finish");

        return tickets;
    }

    private boolean checkTicketId(Vector<Ticket> tickets){
        HashSet<Integer> set = new HashSet<>();
        for (Ticket ticket : tickets){
            if (set.contains(ticket.getId())){
                return false;
            }
            set.add(ticket.getId());
        }
        return true;
    }
    public void save(Vector<Ticket> vector) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateAdapter()).setPrettyPrinting().create();
        //try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Main.class.getClassLoader().getResource(fileName).toURI())))) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter( fileName))) {
            gson.toJson(vector, bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    try (Writer writer = new FileWriter("Output.json")) {
    Gson gson = new GsonBuilder().create();
    gson.toJson(users, writer);
    }
    public void writeCollection(Collection<?> collection) {
        if (System.getenv().get(envVariable) != null) {
            try (FileWriter collectionFileWriter = new FileWriter(new File(System.getenv().get(envVariable)))) {
                collectionFileWriter.write(gson.toJson(collection));
                Console.println("Коллекция успешна сохранена в файл!");
            } catch (IOException exception) {
                Console.printerror("Загрузочный файл является директорией/не может быть открыт!");
            }
        } else Console.printerror("Системная переменная с загрузочным файлом не найдена!");
    }
     */
}
