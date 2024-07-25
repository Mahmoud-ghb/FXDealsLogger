package com.example.FXDealsLogger.repository;

import com.example.FXDealsLogger.api.model.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<DealEntity, Long> {
    boolean existsByDealId(String dealId);
}
