package com.example.FXDealsLogger;

import com.example.FXDealsLogger.api.controller.DealController;
import com.example.FXDealsLogger.api.model.DealEntity;
import com.example.FXDealsLogger.repository.DealRepository;
import com.example.FXDealsLogger.service.DealService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FxDealsLoggerApplicationTests {


	@Autowired
	private DealRepository dealRepository;

	@Test
	public void testCreateDeal() {
		DealEntity deal = new DealEntity();
		deal.setDealId("12345");
		deal.setFromCurrencyIsoCode("USD");
		deal.setToCurrencyIsoCode("EUR");
		deal.setDealTimestamp(LocalDateTime.now());
		deal.setDealAmount(1000.50);

		dealRepository.save(deal);

		Optional<DealEntity> foundDeal = dealRepository.findById(deal.getId());
		assertThat(foundDeal).isPresent();
		assertThat(foundDeal.get().getDealId()).isEqualTo("12345");
	}
	@Test
	public void testSaveAndFindDeal() {
		DealEntity deal = new DealEntity();
		deal.setDealId("12345");
		deal.setFromCurrencyIsoCode("USD");
		deal.setToCurrencyIsoCode("EUR");
		deal.setDealTimestamp(LocalDateTime.now());
		deal.setDealAmount(1000.50);

		dealRepository.save(deal);

		Optional<DealEntity> foundDeal = dealRepository.findById(deal.getId());
		assertThat(foundDeal).isPresent();
		assertThat(foundDeal.get().getDealId()).isEqualTo("12345");
	}

	@Test
	public void testExistsByDealId() {
		DealEntity deal = new DealEntity();
		deal.setDealId("12345");
		deal.setFromCurrencyIsoCode("USD");
		deal.setToCurrencyIsoCode("EUR");
		deal.setDealTimestamp(LocalDateTime.now());
		deal.setDealAmount(1000.50);

		dealRepository.save(deal);

		boolean exists = dealRepository.existsByDealId("12345");
		assertThat(exists).isTrue();
	}
}
