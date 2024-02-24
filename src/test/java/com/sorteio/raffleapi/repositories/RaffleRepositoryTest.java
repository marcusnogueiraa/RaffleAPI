package com.sorteio.raffleapi.repositories;

import static com.sorteio.raffleapi.common.RaffleConstants.EMPTY_RAFFLE;
import static com.sorteio.raffleapi.common.RaffleConstants.NULL_RAFFLE;
import static com.sorteio.raffleapi.common.RaffleConstants.RAFFLE;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Optional;

import com.sorteio.raffleapi.entities.Raffle;
import com.sorteio.raffleapi.repositories.RaffleRepository;

import jakarta.persistence.EntityNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.EmptyResultDataAccessException;

@DataJpaTest
public class RaffleRepositoryTest {
    
    @Autowired
    private RaffleRepository raffleRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @AfterEach
    public void afterEach(){
        RAFFLE.setId(null);
    }

    @Test
    public void createRaffle_WithValidData_ReturnsRaffle() {
        raffleRepository.save(RAFFLE);

        Raffle sut = testEntityManager.find(Raffle.class, RAFFLE.getId());

        assertThat(sut).isNotNull();
        assertThat(sut.getTitle()).isEqualTo(RAFFLE.getTitle());
        assertThat(sut.getDescription()).isEqualTo(RAFFLE.getDescription());
        assertThat(sut.getNumberOfTickets()).isEqualTo(RAFFLE.getNumberOfTickets());
    }

    @Test
    public void createRaffle_WithNullData_ThrowsException(){
        assertThatThrownBy(() -> raffleRepository.save(NULL_RAFFLE));
    }

    @Test
    public void createRaffle_WithEmptyData_ThrowsException(){
        assertThatThrownBy(() -> raffleRepository.save(EMPTY_RAFFLE));
    }

    @Test
    public void createRaffle_WithInvalidNumberOfTickets_ThrowsException(){
        Raffle raffleWithZeroTicketsNumber = new Raffle("Title","Description", 0);
        Raffle raffleWithNegativeTicketsNumber = new Raffle("Title","Description", -1);
        Raffle raffleWithNullTicketsNumber = new Raffle("Title", "Description", null);

        assertThatThrownBy(() -> raffleRepository.save(raffleWithZeroTicketsNumber));
        assertThatThrownBy(() -> raffleRepository.save(raffleWithNegativeTicketsNumber));
        assertThatThrownBy(() -> raffleRepository.save(raffleWithNullTicketsNumber));
    }

    @Test
    public void createRaffle_WithExistingId_UpdatesRaffle(){
        Raffle raffle = testEntityManager.persistFlushFind(RAFFLE);

        Raffle updatedRaffle = new Raffle("NewTitle", "NewDesc", 100);
        updatedRaffle.setId(raffle.getId());

        raffleRepository.save(updatedRaffle);
        Raffle sut = testEntityManager.find(Raffle.class, updatedRaffle.getId());

        assertThat(updatedRaffle).isEqualToComparingFieldByField(sut);
    }

    @Test
    public void getRaffle_ByExistingId_ReturnsRaffle(){
        Raffle raffle = testEntityManager.persistFlushFind(RAFFLE);
        Optional<Raffle> raffleOptional = raffleRepository.findById(raffle.getId());
        
        assertThat(raffleOptional).isNotEmpty();
        assertThat(raffleOptional.get()).isEqualTo(raffle);
    }

    @Test
    public void getRaffle_ByUnexistingId_ReturnsEmpty(){
        Optional<Raffle> raffleOptional = raffleRepository.findById(1L);

        assertThat(raffleOptional).isEmpty();
    }

    @Test
    public void getAllRaffles_ReturnsAllRaffles(){
        Raffle raffle1 = new Raffle("title1", "desc1", 100);
        Raffle raffle2 = new Raffle("title2", "desc2", 15);
        
        testEntityManager.persistAndFlush(raffle2);
        testEntityManager.persistAndFlush(raffle1);

        List<Raffle> allRaffles = raffleRepository.findAll();
        
        assertThat(allRaffles).isNotEmpty();
        assertThat(allRaffles.size()).isEqualTo(2);
        assertThat(allRaffles).contains(raffle1, raffle2);
    }

    @Test
    public void getAllRaffles_WithNoData_ReturnsEmptyRaffleList(){
        List<Raffle> allRaffles = raffleRepository.findAll();

        assertThat(allRaffles).isEmpty();
    }

    @Test
    public void removeRaffle_WithExistingId_RemovesRaffleFromDatabase(){
        Raffle raffle = testEntityManager.persistFlushFind(RAFFLE);

        raffleRepository.deleteById(raffle.getId());

        Raffle removedRaffle = testEntityManager.find(Raffle.class, raffle.getId());
        assertThat(removedRaffle).isNull();
    }
}
