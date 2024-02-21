package com.sorteio.raffleapi.entities;

import org.springframework.data.annotation.Id;
import jakarta.persistence.Table;

@Table(name = "Tickets")
public class Ticket {
    
    @Id
    private Long id;
    private String number;
    private String buyerName;
    private String sellerName;

    public Ticket(String number, String buyerName, String sellerName){
        this.number = number;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
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

    public String getSellerName(){
        return sellerName;
    }

    public void setSellerName(String sellerName){
        this.sellerName = sellerName;
    }

}
