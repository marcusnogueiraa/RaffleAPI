package com.sorteio.raffleapi.controllers;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorteio.raffleapi.entities.Ticket;
import com.sorteio.raffleapi.services.TicketService;

@RestController
@RequestMapping("api/raffles/{raffleId}/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTicketsOfaRafflle(String raffleId){
        // Todo: Make this Function
        return new ArrayList<>();
    }

    @GetMapping("/{ticketNumber}")
    public Ticket getTicketByNumber(@PathVariable("raffleId") Long raffleId, @PathVariable("ticketNumber") Integer ticketNumber){
        return ticketService.getTicketByNumber(raffleId, ticketNumber);
    }
    
    @PostMapping
    public void addTicketToRaffle(@PathVariable("raffleId") Long raffleId, @RequestBody Ticket ticket){
        ticketService.addTicketToRaffle(raffleId, ticket);
    }
}
