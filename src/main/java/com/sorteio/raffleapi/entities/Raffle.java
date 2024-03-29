package com.sorteio.raffleapi.entities;

import com.sorteio.raffleapi.entities.User;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Raffles")
public class Raffle {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty @Column(length = 50)
    private String title;

    @NotEmpty @Column(length = 300)
    private String description;

    @Positive @NotNull
    private Integer numberOfTickets;

    private Integer ticketsAvailable;

    @ManyToOne @JoinColumn(name = "admin_id")
    private User admin;

    @OneToMany(mappedBy = "raffle", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    @ManyToMany
    private List<User> sellers = new ArrayList<>();

    public Raffle(){}

    public Raffle(String title, String description, Integer numberOfTickets){
        this.title = title;
        this.description = description;
        this.numberOfTickets = (numberOfTickets != null) ? numberOfTickets : 0;
    }

    @PrePersist
    private void prePersist() {
        this.ticketsAvailable = (numberOfTickets != null) ? numberOfTickets : 0;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
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
