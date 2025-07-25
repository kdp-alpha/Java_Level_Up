package com.project.Currency.Converter.external;

import com.project.Currency.Converter.model.ExchangeRateResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ExchangeRateClient {
    static final String API_KEY = "dc8c4b6ddf3e70ba60c586dce33ebde6";

    RestClient restClient = RestClient.builder()
            .baseUrl("https://api.exchangeratesapi.io/v1")
            .build();

    public ExchangeRateResponse getRatesForBase(String baseCurrency){
        ExchangeRateResponse response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/latest")
                        .queryParam("access_key",API_KEY)
                        .build())
                .retrieve()
                .body(ExchangeRateResponse.class);

        return response;
    }
}
