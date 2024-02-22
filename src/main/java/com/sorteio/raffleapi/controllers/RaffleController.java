package com.sorteio.raffleapi.controllers;

import java.util.List;
import com.sorteio.raffleapi.entities.Raffle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sorteio.raffleapi.services.RaffleService;

@RestController
@RequestMapping("api/raffles")
public class RaffleController {
    
    @Autowired
    private RaffleService raffleService;

    @GetMapping
    public List<Raffle> getAllRaffles(){
        return raffleService.getAllRaffles();
    }

    @GetMapping("/{id}")
    public Raffle getAllRaffleById(@PathVariable("id") Long id){
        return raffleService.getRaffleById(id);
    }

    @PostMapping
    public Raffle createRaffle(@RequestBody Raffle raffle){
        return raffleService.createRaffle(raffle);
    }

    @PutMapping
    public void updateRaffle(@RequestBody Raffle raffle){
        raffleService.updateRaffle(raffle);
    }

    @DeleteMapping("/{id}")
    public void deleteRaffleById(@PathVariable("id") Long id){
        raffleService.deleteRaffleById(id);
    }
}
