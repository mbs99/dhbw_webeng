package de.dhbw.webeng.swapisearch.view;

public class SearchForm {
  private String searchInput;
  private PlanetInfo[] results;

  public String getSearchInput() {
    return searchInput;
  }

  public void setSearchInput(String searchInput) {
    this.searchInput = searchInput;
  }

  public PlanetInfo[] getResults() {
    return results;
  }

  public void setResults(PlanetInfo[] results) {
    this.results = results;
  }
}
