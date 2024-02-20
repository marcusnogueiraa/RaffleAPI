package com.sorteio.raffleapi.services;

import java.util.List;
import java.util.Optional;

import com.sorteio.raffleapi.entities.Raffle;
import org.springframework.stereotype.Service;
import com.sorteio.raffleapi.repositories.RaffleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RaffleService {
    
    @Autowired
    private RaffleRepository raffleRepository;

    public List<Raffle> getAllRaffles(){
        return raffleRepository.findAll();
    }

    public Raffle getRaffleById(String id){
        Optional<Raffle> searchedRaffle = raffleRepository.findById(id);
        return searchedRaffle.orElse(null);
    }

    public void createRaffle(Raffle raffle){
        raffleRepository.save(raffle);
    }

    public void updateRaffle(Raffle raffle){
        raffleRepository.save(raffle);
    }

    public void deleteRaffleById(String id){
        raffleRepository.deleteById(id);
    }
}
