package com.project.Currency.Converter.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="currency")
public class CurrencyConversion extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long Id;

    private String baseCurrency;

    private String convertCurrency;

    private Double conversionRate;
}
