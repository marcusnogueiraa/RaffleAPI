package com.sorteio.raffleapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorteio.raffleapi.entities.Ticket;
import com.sorteio.raffleapi.services.TicketService;

@RestController
@RequestMapping("api/raffles/{raffleId}/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    public List<Ticket> getAllTicketsOfaRafflle(String raffleId){
        return ticketService.getAllTicketsOfaRafflle(raffleId);
    }
    
}
