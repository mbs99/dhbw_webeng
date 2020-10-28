package de.mbs.basicsoap.endpoints;

import de.mbs.basicsoap.api.Currency;
import de.mbs.basicsoap.api.GetCountryRequest;
import de.mbs.basicsoap.api.GetCountryResponse;
import de.mbs.basicsoap.model.Country;
import de.mbs.basicsoap.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Arrays;
import java.util.Optional;

@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        Country country = countryRepository.findCountry(request.getName());
        response.setCountry(this.mapCountry(country));

        return response;

    }

    private de.mbs.basicsoap.api.Country mapCountry(Country country) {
        de.mbs.basicsoap.api.Country response = new de.mbs.basicsoap.api.Country();

        response.setCapital(country.getCapital());
        response.setCurrency(mapCurrency(country.getCurrency()));
        response.setName(country.getName());
        response.setPopulation(country.getPopulation());

        return response;
    }

    private Currency mapCurrency(String currency) {
       Optional<Currency> mappedCurrency = Arrays.stream(Currency.values()).filter(value -> value.name().equalsIgnoreCase(currency)).findFirst();
       return mappedCurrency.isPresent() ? mappedCurrency.get() : null;
    }
}