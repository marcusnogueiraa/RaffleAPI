package com.sorteio.raffleapi.repositories;

import com.sorteio.raffleapi.entities.Raffle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RaffleRepository extends MongoRepository<Raffle, String> {}
