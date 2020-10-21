package de.dhbw.webeng.swapisearch.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanetSearchResult {
  @JsonProperty("results")
  private Planet[] results;

  @JsonProperty("count")
  private String count;

  @JsonProperty("next")
  private String next;

  @JsonProperty("previous")
  private String previous;

  public Planet[] getResults() {
    return results;
  }

  public void setResults(Planet[] results) {
    this.results = results;
  }

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }
}
