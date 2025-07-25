package com.project.Currency.Converter.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        //get secutiry context
        // get authetication
        //get the principal
        //get the username
        return Optional.of("Karan Dinkar Pawar");
    }
}