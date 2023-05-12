package org.example.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.dataAdapter.DateAdapter;
import org.example.exception.IdException;
import org.example.commands.TicketBuilder;
import org.example.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;
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
            throw new IdException();
        }
        boolean check = true;

        for (Ticket ticket : tickets){
            if (ticket.getEvent().getId() == 0) {
                ticket.getEvent().setId(TicketBuilder.makeEventId(ticket.getEvent().getName(), ticket.getEvent().getDate(), ticket.getEvent().getMinAge()));
            }




            ticket.checkTicket();
        }

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
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter( fileName))) {
            gson.toJson(vector, bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
