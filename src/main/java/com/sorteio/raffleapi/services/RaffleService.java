package com.sorteio.raffleapi.services;

import java.util.List;
import java.util.Optional;

import com.sorteio.raffleapi.entities.Raffle;
import com.sorteio.raffleapi.repositories.RaffleRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RaffleService {
    
    @Autowired
    private RaffleRepository raffleRepository;

    public List<Raffle> getAllRaffles(){
        return raffleRepository.findAll();
    }

    public Raffle getRaffleById(Long id){
        Optional<Raffle> searchedRaffle = raffleRepository.findById(id);
        return searchedRaffle.orElse(null);
    }

    public Raffle createRaffle(Raffle raffle){
        return raffleRepository.save(raffle);
    }

    public Raffle updateRaffle(Raffle raffle){
        return raffleRepository.save(raffle);
    }

    public Boolean deleteRaffleById(Long id){
        Optional<Raffle> searchedRaffle = raffleRepository.findById(id);

        if (searchedRaffle.isPresent()){
            raffleRepository.delete(searchedRaffle.get());
            return true;
        } 

        return false;
    }
}
