package de.mbs.basicsoap.repo;

import de.mbs.basicsoap.model.Country;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        countries.put("Germany", new Country("Germany", 80000000, "Berlin", "EUR"));
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
