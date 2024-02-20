package com.sorteio.raffleapi.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tickets")
public class Ticket {
    
    @Id
    private String id;
    private String number;
    private String buyerName;

    public Ticket(String number, String buyerName){
        this.number = number;
        this.buyerName = buyerName;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getBuyerName(){
        return this.buyerName;
    }

    public void setBuyerName(String buyerName){
        this.buyerName = buyerName;
    }

}
