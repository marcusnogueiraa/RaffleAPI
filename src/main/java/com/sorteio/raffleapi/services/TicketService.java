package com.sorteio.raffleapi.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.sorteio.raffleapi.entities.Raffle;
import com.sorteio.raffleapi.entities.Ticket;
import com.sorteio.raffleapi.repositories.RaffleRepository;
import com.sorteio.raffleapi.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    private RaffleRepository raffleRepository;

    public List<Ticket> getAllTicketsOfaRafflle(Long raffleId){
        return ticketRepository.findAllByRaffleId(raffleId); 
    }

    public Ticket getTicketByNumber(Long raffleId, Integer ticketNumber){
        Optional<Ticket> searchedTicket = ticketRepository.findByRaffleIdAndTicketNumber(raffleId, ticketNumber);
        return searchedTicket.orElseThrow();
    }

    public void addTicketToRaffle(Long raffleId, Ticket ticket){
        Optional<Raffle> searchedRaffle = raffleRepository.findById(raffleId);
        
        if (searchedRaffle.isPresent()){
            ticket.setRaffle(searchedRaffle.get());
            ticketRepository.save(ticket);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Raffle not found with ID: " + raffleId);
        }
    }

    public void updateTicket(Long raffleId, Ticket ticket){
        if (raffleRepository.existsById(raffleId)){
            ticketRepository.save(ticket);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Raffle not found with ID: " + raffleId);
        }
    }


}