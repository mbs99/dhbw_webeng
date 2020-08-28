package de.webeng;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.webeng.model.Company;
import de.webeng.model.Staff;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private ObjectMapper mapper = new ObjectMapper();

    public Company parse(InputStream jsonStream) throws IOException {

        List<Staff> staff = Arrays.asList(mapper.readValue(jsonStream, Staff[].class));
        return new Company(staff);
    }
}
