package com.example.FXDealsLogger.controller;


import com.example.FXDealsLogger.api.controller.DealController;
import com.example.FXDealsLogger.api.model.DealEntity;
import com.example.FXDealsLogger.service.DealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class DealControllerTest {

    @Mock
    private DealService dealService;

    @Mock
    private Logger logger;
    @InjectMocks
    private DealController dealController;

    private MockMvc mockMvc;



    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(dealController).build();
    }


    @Test
    void createDeal_ShouldReturnSavedDeal_WhenValidRequest() throws Exception {
        Path dealsPath = ResourceUtils.getFile("classpath:deal.json").toPath();
        String dealsJson = new String(Files.readAllBytes(dealsPath));

        DealEntity savedDeal = new DealEntity();

        when(dealService.saveDeal(any(DealEntity.class))).thenReturn(savedDeal);
        mockMvc.perform(post("/api/deals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dealsJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dealId").value(savedDeal.getDealId()));

        verify(dealService, times(1)).saveDeal(any(DealEntity.class));
    }
}
