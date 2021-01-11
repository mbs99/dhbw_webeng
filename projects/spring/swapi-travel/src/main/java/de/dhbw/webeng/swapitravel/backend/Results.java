package de.dhbw.webeng.swapitravel.backend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties
public class Results {
    @JsonProperty("count")
    public Integer count;

    @JsonProperty("next")
    public String next;

    @JsonProperty("previous")
    public String previous;

    @JsonProperty("results")
    public List<StarshipModel> starships;
}
