package com.example.FXDealsLogger.api.controller;


import com.example.FXDealsLogger.api.model.DealEntity;
import com.example.FXDealsLogger.service.*;
//import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/deals")
@AllArgsConstructor
public class DealController {

    private static final Logger logger = LoggerFactory.getLogger(DealController.class);

    @Autowired
    private DealService dealService;

    @PostMapping
    public ResponseEntity<DealEntity> createDeal(@Valid @RequestBody DealEntity deal) {
        logger.info("Received request to create deal: {}", deal);

        DealEntity savedDeal = dealService.saveDeal(deal);
        logger.info("Deal created successfully with ID: {}", savedDeal.getId());

        return ResponseEntity.ok(savedDeal);
    }
}
