package de.webeng;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.webeng.model.Company;
import de.webeng.model.Staff;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Parser {

    public Company parse(InputStream jsonStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Staff> staff = Arrays.asList(mapper.readValue(jsonStream, Staff[].class));
        return new Company(staff);
    }
}
