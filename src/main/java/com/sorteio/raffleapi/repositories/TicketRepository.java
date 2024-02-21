package com.sorteio.raffleapi.repositories;

import com.sorteio.raffleapi.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
