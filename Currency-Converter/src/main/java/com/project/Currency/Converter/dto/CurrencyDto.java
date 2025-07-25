package com.project.Currency.Converter.dto;

import lombok.Data;

@Data
public class CurrencyDto {
    private String baseCurrency;
    private String convertCurrency;
    private float conversionRate;
}
