package de.webeng;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.webeng.model.Company;

import java.io.IOException;

public class Starter {
    public static void main(String[] args) {
        XmlMapper mapper = new XmlMapper();
        try {
            Company company = mapper.readValue(Starter.class.getResourceAsStream("/xml/company.xml"), Company.class);
            System.out.println(company);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
