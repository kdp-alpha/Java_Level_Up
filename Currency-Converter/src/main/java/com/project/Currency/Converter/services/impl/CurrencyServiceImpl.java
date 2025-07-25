package com.project.Currency.Converter.services.impl;


import com.project.Currency.Converter.dto.CurrencyDto;
import com.project.Currency.Converter.external.ExchangeRateClient;
import com.project.Currency.Converter.model.ExchangeRateResponse;
import com.project.Currency.Converter.repositories.CurrencyRepository;
import com.project.Currency.Converter.services.CurrencyService;
import com.project.Currency.Converter.entities.CurrencyConversion;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final ModelMapper modelMapper;
    private final ExchangeRateClient exchangeRateClient;

    @Override
    public void getExchangeRates(String baseCurrency){
        ExchangeRateResponse response = exchangeRateClient.getRatesForBase(baseCurrency);

        response.getRates().forEach((targetCurrency,rate) -> {
            CurrencyConversion currencyConversion = new CurrencyConversion();

            currencyConversion.setBaseCurrency(baseCurrency);
            currencyConversion.setConvertCurrency(targetCurrency);
            currencyConversion.setConversionRate(rate);

            currencyRepository.save(currencyConversion);
        });
    }

    @Override
    public CurrencyDto getRateOfTargetCurrency(String targetCurrency) {
        CurrencyConversion conversion = currencyRepository.findByConvertCurrency(targetCurrency)
                .orElseThrow(() -> new RuntimeException("Currency not found for: " + targetCurrency));

        return modelMapper.map(conversion, CurrencyDto.class);


    }
}
