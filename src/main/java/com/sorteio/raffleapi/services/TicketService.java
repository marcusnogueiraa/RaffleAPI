package com.sorteio.raffleapi.services;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import com.sorteio.raffleapi.entities.Raffle;
import com.sorteio.raffleapi.entities.Ticket;
import com.sorteio.raffleapi.repositories.RaffleRepository;
import com.sorteio.raffleapi.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private RaffleRepository raffleRepository;
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTicketsOfaRafflle(String raffleId){
        Optional<Raffle> searchedRaffle = raffleRepository.findById(raffleId);

        if (searchedRaffle.isPresent())
            return searchedRaffle.get().getTicketsList();
    
        return new ArrayList<>();
    }


}