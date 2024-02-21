package com.sorteio.raffleapi.repositories;

import com.sorteio.raffleapi.entities.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {}
