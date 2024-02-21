package com.sorteio.raffleapi.entities;

import java.util.List;
import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Raffles")
public class Raffle {
    
    @Id
    private String id;
    private String title;
    private String description;
    private Integer numberOfTickets;
    private Integer ticketsAvailable;

    @DBRef
    private List<Ticket> ticketsList;

    public Raffle(String title, String description, Integer numberOfTickets, Integer ticketsAvailable, List<Ticket> ticketsList){
        this.title = title;
        this.description = description;
        this.numberOfTickets = numberOfTickets;
        this.ticketsAvailable = ticketsAvailable;
        this.ticketsList = ticketsList;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Integer getNumberOfTickets(){
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets){
        this.numberOfTickets = numberOfTickets;
    }

    public Integer getTicketsAvailable(){
        return ticketsAvailable;
    }

    public void setTicketsAvailable(Integer ticketsAvaiable){
        this.ticketsAvailable = ticketsAvaiable;
    }

}
