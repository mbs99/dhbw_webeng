package de.webeng;

import de.webeng.model.Company;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Parser parser = new Parser();
        try {
            Company company = parser.parse(Parser.class.getResourceAsStream("/company.json"));
            company.getStaff().forEach(staff -> System.out.println(staff.getFirstname()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
