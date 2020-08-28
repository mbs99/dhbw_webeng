package de.webeng;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.webeng.model.Company;

import java.io.IOException;
import java.io.InputStream;

public class Parser {
    private ObjectMapper mapper = new ObjectMapper();

    public Company parse(InputStream jsonStream) throws IOException {
        return mapper.readValue(jsonStream, Company.class);
    }
}
