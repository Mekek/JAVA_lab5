package org.example.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Mikhail Kadilov
 * The 'Event' class created to work with events
 */
public class Event implements Comparable<Event>{
    private int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDate date; //Поле не может быть null
    private Integer minAge; //Поле может быть null

    public Event(int id, String name, LocalDate date, int minAge) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.minAge = minAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.time.LocalDate getDate() {
        return date;
    }

    public void setDate(java.time.LocalDate date) {
        this.date = date;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    /**
     * Compares two Event objects by their fields
     * @param o - Event object to compare
     * @return - negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object
     */


    @Override
    public int compareTo(Event o) {
        return name.compareTo(o.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, minAge);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", minAge=" + minAge +
                '}';
    }


}