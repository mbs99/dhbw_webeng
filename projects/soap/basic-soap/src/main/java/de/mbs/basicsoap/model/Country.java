package de.mbs.basicsoap.model;

public class Country {

    private String name;
    private int population;
    private String capital;
    private String currency;

    public Country(String name, int population, String capital, String currency) {
        this.name = name;
        this.population = population;
        this.capital = capital;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public String getCurrency() {
        return currency;
    }


}
