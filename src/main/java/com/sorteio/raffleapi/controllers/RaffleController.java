package com.sorteio.raffleapi.controllers;

import jakarta.validation.Valid;

import java.util.List;
import com.sorteio.raffleapi.entities.Raffle;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Raffle> getAllRaffleById(@PathVariable("id") Long id){
        Raffle searchedRaffle = raffleService.getRaffleById(id);
        
        if (searchedRaffle == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(searchedRaffle);
        }
    }

    @PostMapping
    public ResponseEntity<Raffle> createRaffle(@RequestBody @Valid Raffle raffle){
        Raffle createdRaffle = raffleService.createRaffle(raffle);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRaffle);
    }

    @PutMapping
    public Raffle updateRaffle(@RequestBody @Valid Raffle raffle){
        return raffleService.updateRaffle(raffle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRaffleById(@PathVariable("id") Long id){
        Boolean hasDeleted = raffleService.deleteRaffleById(id);

        if (hasDeleted){    
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
