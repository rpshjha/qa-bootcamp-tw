package com.vodqa.flightdetails.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodqa.flightdetails.controllers.FlightController;
import com.vodqa.flightdetails.dto.FlightDetailRequest;
import com.vodqa.flightdetails.entities.Flight;
import com.vodqa.flightdetails.repos.FlightRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by divyar on 9/13/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    private MockMvc mockMvc;

    private JacksonTester< FlightDetailRequest > jsonTester;

    @MockBean
    private FlightRepository flightRepository;

    private ObjectMapper objectMapper;

    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @InjectMocks
    private FlightController flightController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.jackson2ObjectMapperBuilder = new Jackson2ObjectMapperBuilder();
        this.mockMvc = standaloneSetup(flightController).build();
        objectMapper = jackson2ObjectMapperBuilder.build();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void findFlights() throws Exception {

        FlightDetailRequest flightDetailRequest = new FlightDetailRequest("DEL", "BOM", "2018-09-09");
        List<Flight> flights = new ArrayList<>();
        given(flightRepository.findFlights("DEL", "BOM", new Date())).willReturn(flights);
        final String flightDetailRequestJson = jsonTester.write(flightDetailRequest).getJson();

        System.out.println(flightDetailRequestJson);
        String requestBody = objectMapper.writeValueAsString(flightDetailRequest);
        System.out.println(requestBody);
        mockMvc.perform(post("/findFlights")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isCreated());
    }

    @Test
    public void findAllFlights() throws Exception {

        List<Flight> flights = new ArrayList<>();
        given(flightRepository.findAll()).willReturn(flights);

        mockMvc.perform(get("/findAllFlights"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
    }


    @Test
    public void findFlightsByFlightid() throws Exception {

        Long flightId = 1L;
        given(flightRepository.findOne(flightId)).willReturn(
                new Flight("", "", "", "",
                        new Date(), new Timestamp(34)));

        mockMvc.perform(get("/findFlight/"+flightId.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn();
    }

    @Test
    public void findFlightsForInvalidFlightid() throws Exception {

        Long flightId = 100L;
        given(flightRepository.findOne(flightId)).willReturn(
                new Flight("", "", "", "",
                        new Date(), new Timestamp(34)));

        mockMvc.perform(get("/findFlight/"+flightId.toString())
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isInternalServerError())
                .andReturn();
    }


    @Test
    public void checkHealth() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk());
    }


    private byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }


}
