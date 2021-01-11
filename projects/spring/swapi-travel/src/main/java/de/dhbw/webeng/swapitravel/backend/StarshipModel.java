package de.dhbw.webeng.swapitravel.backend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class StarshipModel {
    @JsonProperty("passengers")
    public String passengers;
    @JsonProperty("name")
    public String name;
    @JsonProperty("model")
    public String model;
}
