package org.example.model;

import org.example.exception.NullArgumentException;

import java.util.Objects;

public class Ticket implements Comparable<Ticket>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate  creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float price; //Поле не может быть null, Значение поля должно быть больше 0
    private TicketType type; //Поле не может быть null
    private Event event; //Поле не может быть null
    public Ticket(Integer id, String name, Coordinates coordinates, java.time.LocalDate  creationDate, Float price, TicketType type, Event event) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.type = type;
        this.event = event;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public java.time.LocalDate  getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.time.LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Float getPrice() {
        if (price != null) {
            return price;
        }
        return Float.valueOf(0);
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", type=" + type +
                ", event=" + event +
                '}';
    }
    @Override
    public int compareTo(Ticket o) {
        if ((float) price != o.price) {
            return Float.compare(price, o.price);
        }
        if (creationDate.compareTo(o.creationDate) != 0) {
            return creationDate.compareTo(o.creationDate);
        }
        return Long.compare(id, o.id);
    }

    public void checkTicket(){
            if (getId() == null) throw new NullArgumentException("id не может быть null");
            if (getId() <= 0) throw new IllegalArgumentException("id не положительный");
            if (Objects.equals(getName(),"null") || getName() == null || getName().isEmpty() || getName().isBlank()) throw new NullArgumentException("имя пустое");
            if (getCoordinates() == null) throw  new NullArgumentException("пустые координаты");
            if (getCreationDate() == null)throw new NullArgumentException("нулевое время");
            if (getPrice() <= 0) throw new IllegalArgumentException("стоимость <= 0");
            if (getType() == null) throw new NullArgumentException("некорректный тип");
            if (getEvent().getId() <= 0) throw new IllegalArgumentException("id события не положительный " + getEvent().getName());
            if (getEvent().getName().length() > 1847) throw  new IllegalArgumentException("некорректный формат полного имени");
            if (getEvent().getDate() == null) throw new NullArgumentException("нулевое время");
            if (getEvent().getMinAge() <= 0) throw  new IllegalArgumentException("минимальный возраст <= 0");
    }
}


