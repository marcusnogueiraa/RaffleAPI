package com.sorteio.raffleapi.entities;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tickets")
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private Integer number;
    private String buyerName;
    private String sellerName;

    @ManyToOne
    @JoinColumn(name = "raffle_id")
    private Raffle raffle;

    public Ticket(Integer number, String buyerName, String sellerName){
        this.number = number;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
    }

    public Long getId(){
        return this.id;
    }

    public Integer getNumber(){
        return number;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

    public String getBuyerName(){
        return this.buyerName;
    }

    public void setBuyerName(String buyerName){
        this.buyerName = buyerName;
    }

    public String getSellerName(){
        return sellerName;
    }

    public void setSellerName(String sellerName){
        this.sellerName = sellerName;
    }

    public void setRaffle(Raffle raffle){
        this.raffle = raffle;
    }

}
