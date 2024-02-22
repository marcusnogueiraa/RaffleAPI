package com.sorteio.raffleapi.repositories;

import com.sorteio.raffleapi.entities.Raffle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaffleRepository extends JpaRepository<Raffle, Long> {

}
