package com.sorteio.raffleapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static com.sorteio.raffleapi.common.RaffleConstants.RAFFLE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sorteio.raffleapi.controllers.RaffleController;
import com.sorteio.raffleapi.entities.Raffle;
import com.sorteio.raffleapi.services.RaffleService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(RaffleController.class)
public class RaffleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RaffleService raffleService;

    @Test
    public void createRaffle_WithValidData_ReturnsCreated() throws Exception {
        // Configura o comportamento do serviço mock
        when(raffleService.createRaffle(RAFFLE)).thenReturn(RAFFLE);

        // Realiza a chamada ao endpoint
        mockMvc.perform(post("/api/raffles")
                .content(asJsonString(RAFFLE))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$").exists());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}