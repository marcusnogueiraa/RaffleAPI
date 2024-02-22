package com.sorteio.raffleapi.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Raffles")
public class Raffle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Column(length = 250)
    private String description;

    private Integer numberOfTickets;
    private Integer ticketsAvailable;

    @OneToMany(mappedBy = "raffle", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Raffle(String title, String description, Integer numberOfTickets){
        this.title = title;
        this.description = description;
        this.numberOfTickets = numberOfTickets;
        this.ticketsAvailable = numberOfTickets;
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

    public void setTicketsAvailable(Integer ticketsAvailable){
        this.ticketsAvailable = ticketsAvailable;
    }

}
