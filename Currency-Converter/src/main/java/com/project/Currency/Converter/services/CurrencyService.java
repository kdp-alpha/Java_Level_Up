package com.project.Currency.Converter.services;

import com.project.Currency.Converter.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {
    void getExchangeRates(String baseCurrency);

    CurrencyDto getRateOfTargetCurrency(String targetCurrency);
}
