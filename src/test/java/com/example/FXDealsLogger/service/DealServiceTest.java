package com.example.FXDealsLogger.service;

import com.example.FXDealsLogger.api.model.DealEntity;
import com.example.FXDealsLogger.exception.DealAlreadyExistsException;
import com.example.FXDealsLogger.repository.DealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class DealServiceTest {

    @InjectMocks
    private DealService dealService;

    @Mock
    private DealRepository dealRepository;

    private DealEntity dealEntity;

    @BeforeEach
    public void setUp() {
        dealEntity = new DealEntity();
        dealEntity.setDealId("dealId123");

    }


    @Test
    public void saveDeal_ShouldThrowException_WhenDealAlreadyExists() {
        // Given
        when(dealRepository.existsByDealId(dealEntity.getDealId())).thenReturn(true);

        // When & Then
        assertThrows(DealAlreadyExistsException.class, () -> dealService.saveDeal(dealEntity));
    }

    @Test
    public void saveDeal_ShouldSaveDeal_WhenDealIsNew() {
        // Given
        when(dealRepository.existsByDealId(dealEntity.getDealId())).thenReturn(false);
        when(dealRepository.save(dealEntity)).thenReturn(dealEntity);

        // When
        DealEntity savedEntity = dealService.saveDeal(dealEntity);

        // Then
        assertEquals(dealEntity, savedEntity);
        verify(dealRepository, times(1)).save(dealEntity);
    }


}


