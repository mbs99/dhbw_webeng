package de.webeng;

public class App {
    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parse(Parser.class.getResourceAsStream("/company.json"));
    }
}