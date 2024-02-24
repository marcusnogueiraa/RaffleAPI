package com.sorteio.raffleapi.common;

import com.sorteio.raffleapi.entities.Raffle;

public class RaffleConstants {
    public static final Raffle RAFFLE = new Raffle("Sorteio", "Example", 100);
    public static final Raffle EMPTY_RAFFLE = new Raffle("","",10);
    public static final Raffle NULL_RAFFLE = new Raffle(null, null, null);
}
