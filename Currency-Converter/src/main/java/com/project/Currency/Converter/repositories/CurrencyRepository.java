package com.project.Currency.Converter.repositories;

import com.project.Currency.Converter.entities.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyConversion,Long> {

    Optional<CurrencyConversion> findByConvertCurrency(String convertCurrency);

}
