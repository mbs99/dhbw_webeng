package de.dhbw.webeng.swapisearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"created", "edited"})
public class Planet {
  @JsonProperty("climate")
  private String climate;

  @JsonProperty("diameter")
  private String diameter;

  @JsonProperty("gravity")
  private String gravity;

  @JsonProperty("name")
  private String name;

  @JsonProperty("orbital_period")
  private String orbital_period;

  @JsonProperty("population")
  private String population;

  @JsonProperty("rotation_period")
  private String rotation_period;

  @JsonProperty("surface_water")
  private String surface_water;

  @JsonProperty("terrain")
  private String terrain;

  @JsonProperty("url")
  private String url;

  @JsonProperty("films")
  private String[] films;

  @JsonProperty("residents")
  private String[] residents;

  public String getClimate() {
    return climate;
  }

  public void setClimate(String climate) {
    this.climate = climate;
  }

  public String getDiameter() {
    return diameter;
  }

  public void setDiameter(String diameter) {
    this.diameter = diameter;
  }

  public String getGravity() {
    return gravity;
  }

  public void setGravity(String gravity) {
    this.gravity = gravity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrbital_period() {
    return orbital_period;
  }

  public void setOrbital_period(String orbital_period) {
    this.orbital_period = orbital_period;
  }

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  public String getRotation_period() {
    return rotation_period;
  }

  public void setRotation_period(String rotation_period) {
    this.rotation_period = rotation_period;
  }

  public String getSurface_water() {
    return surface_water;
  }

  public void setSurface_water(String surface_water) {
    this.surface_water = surface_water;
  }

  public String getTerrain() {
    return terrain;
  }

  public void setTerrain(String terrain) {
    this.terrain = terrain;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String[] getFilms() {
    return films;
  }

  public void setFilms(String[] films) {
    this.films = films;
  }

  public String[] getResidents() {
    return residents;
  }

  public void setResidents(String[] residents) {
    this.residents = residents;
  }

  public boolean findByQuery(String query) {
    StringBuilder buffer = new StringBuilder();
    buffer.append(this.orbital_period);
    buffer.append(" ");
    buffer.append(this.rotation_period);
    buffer.append(" ");
    buffer.append(this.climate);
    buffer.append(" ");
    buffer.append(this.diameter);
    buffer.append(" ");
    buffer.append(this.gravity);
    buffer.append(" ");
    buffer.append(this.name);
    buffer.append(" ");
    buffer.append(this.population);
    buffer.append(" ");
    buffer.append(this.surface_water);
    buffer.append(" ");
    buffer.append(this.terrain);
    buffer.append(" ");

    return (null == query || query.isEmpty() || query.isBlank())
        ? false
        : buffer.toString().toLowerCase().contains(query.toLowerCase());
  }
}
