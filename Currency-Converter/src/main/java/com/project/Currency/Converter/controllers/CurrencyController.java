package com.project.Currency.Converter.controllers;

import com.project.Currency.Converter.dto.CurrencyDto;
import com.project.Currency.Converter.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;
    @PostMapping("/fetch/{baseCurrency}")
    public ResponseEntity<String> fetchAndSaveCurrency(@PathVariable String baseCurrency){
        currencyService.getExchangeRates(baseCurrency);
        return ResponseEntity.ok("Rates fetched and saved successfully"+ baseCurrency);
    }

    @GetMapping("/fetch/{targetCurrency}")
    public ResponseEntity<CurrencyDto> getRateOfTargetCurrency(@PathVariable String targetCurrency){
        return ResponseEntity.ok(currencyService.getRateOfTargetCurrency(targetCurrency));
    }
}
