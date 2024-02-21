package com.sorteio.raffleapi.entities;

import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

@Table(name = "Raffles")
public class Raffle {
    
    @Id
    private String id;
    private String title;
    private String description;
    private Integer numberOfTickets;
    private Integer ticketsAvailable;

    public Raffle(String title, String description, Integer numberOfTickets, Integer ticketsAvailable){
        this.title = title;
        this.description = description;
        this.numberOfTickets = numberOfTickets;
        this.ticketsAvailable = ticketsAvailable;
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
