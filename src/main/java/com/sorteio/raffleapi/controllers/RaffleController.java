package com.sorteio.raffleapi.controllers;

import java.util.List;
import com.sorteio.raffleapi.entities.Raffle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public void createRaffle(@RequestBody Raffle raffle){
        raffleService.createRaffle(raffle);
    }

}
