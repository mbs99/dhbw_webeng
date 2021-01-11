package de.dhbw.webeng.swapitravel.view;

import java.util.List;

public class MainPage {
    private String numPassengers;
    private List<StarshipViewModel> starships;

    public String getNumPassengers() {
        return numPassengers;
    }

    public void setNumPassengers(String numPassengers) {
        this.numPassengers = numPassengers;
    }

    public List<StarshipViewModel> getStarships() {
        return starships;
    }

    public void setStarships(List<StarshipViewModel> starships) {
        this.starships = starships;
    }
}
