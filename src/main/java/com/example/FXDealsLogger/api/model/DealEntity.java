package com.example.FXDealsLogger.api.model;

import com.example.FXDealsLogger.validation.ValidCurrency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Currency;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
//@Table
public class DealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Deal Unique Id is required")
    @Column(name = "dealId", nullable = false, unique = true)
    private String dealId;

    @NotBlank(message = "From Currency ISO Code is required")
    @ValidCurrency(message = "Invalid From Currency ISO Code")
    @Column(name = "fromCurrencyIsoCode", nullable = false)
    private String fromCurrencyIsoCode;

    @NotBlank(message = "To Currency ISO Code is required")
    @ValidCurrency(message = "Invalid From Currency ISO Code")
    @Column(name = "toCurrencyIsoCode", nullable = false)
    private String toCurrencyIsoCode;

    @NotNull(message = "Deal timestamp is required")
    @Column(name = "dealTimestamp", nullable = false)
    private LocalDateTime dealTimestamp;

    @NotNull(message = "Deal Amount is required")
    @Positive(message = "Deal Amount must be positive")
    @Column(name = "dealAmount", nullable = false)
    private Double dealAmount;


}
