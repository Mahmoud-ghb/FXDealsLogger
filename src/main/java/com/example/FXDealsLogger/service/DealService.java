package com.example.FXDealsLogger.service;


import com.example.FXDealsLogger.api.model.DealEntity;
import com.example.FXDealsLogger.exception.DealAlreadyExistsException;
import com.example.FXDealsLogger.repository.DealRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DealService {


    private static final Logger logger = LoggerFactory.getLogger(DealService.class);

    @Autowired
    private DealRepository dealRepository;

    @Transactional
    public DealEntity saveDeal(DealEntity deal) {
        if (dealRepository.existsByDealId(deal.getDealId())) {
            logger.error("Deal with this ID {} already exists", deal.getDealId());
            throw new DealAlreadyExistsException("Deal with this ID already exists");
        }

        logger.debug("Saving deal: {}", deal);

        DealEntity savedDeal = dealRepository.save(deal);
        logger.info("Deal saved successfully with ID: {}", savedDeal.getId());
        return savedDeal;
    }
}
