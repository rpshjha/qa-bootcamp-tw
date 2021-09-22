package com.vodqa.reservation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodqa.reservation.dto.ReservationRequest;
import com.vodqa.reservation.entities.Reservation;
import com.vodqa.reservation.repos.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by divyar on 9/16/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@WebMvcTest(ReservationCheckinController.class)
public class ReservationCheckinControllerTest {


    private MockMvc mockMvc;

    private JacksonTester<ReservationRequest> jsonTester;

    @MockBean
    private ReservationRepository reservationRepository;

    private ObjectMapper objectMapper;

    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @InjectMocks
    private ReservationCheckinController reservationCheckinController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(reservationCheckinController).build();
        this.jackson2ObjectMapperBuilder = new Jackson2ObjectMapperBuilder();
        objectMapper = jackson2ObjectMapperBuilder.build();
        JacksonTester.initFields(this, objectMapper);

    }
        @Test
    public void findReservation() throws Exception {
//        Reservation reservation = new Reservation();
//     given(reservationRepository.findOne(123L)).willReturn(reservation);
//
//        mockMvc.perform(get("/reservations/123"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
//                .andReturn();
      }

    @Test
    public void updateReservation() throws Exception {

    }

}
