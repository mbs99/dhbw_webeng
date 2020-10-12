package de.webeng.basicrest.boundary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NameDto {

  private final String firstName;

  private final String lastName;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public NameDto(
      @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
