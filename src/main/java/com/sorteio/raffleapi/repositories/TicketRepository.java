package com.sorteio.raffleapi.repositories;

import java.util.List;
import java.util.Optional;

import com.sorteio.raffleapi.entities.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findAllByRaffleId(Long raffleId);
    
    @Query("SELECT t FROM Ticket t WHERE t.raffle.id = :raffleId AND t.number = :ticketNumber")
    Optional<Ticket> findByRaffleIdAndTicketNumber(@Param("raffleId") Long raffleId, @Param("ticketNumber") Integer ticketNumber);
}

