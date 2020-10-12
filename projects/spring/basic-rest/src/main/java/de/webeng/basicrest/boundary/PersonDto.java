package de.webeng.basicrest.boundary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.webeng.basicrest.entity.Person;

import java.util.stream.Collectors;

public class PersonDto {

  private NameDto name;

  private AddressDto[] addressList;

  private Long id;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public PersonDto(
      @JsonProperty("id") Long id,
      @JsonProperty("name") NameDto name,
      @JsonProperty("addressList") AddressDto[] addressList) {
    this.id = id;
    this.name = name;
    this.addressList = addressList;
  }

  public static PersonDto from(Person person) {
    return new PersonDto(
        person.id,
        new NameDto(person.firstName, person.lastName),
        person.addresses.stream()
            .map(address -> AddressDto.from(address))
            .collect(Collectors.toList())
            .toArray(AddressDto[]::new));
  }

  public NameDto getName() {
    return name;
  }

  public AddressDto[] getAddressList() {
    return addressList;
  }

  public Long getId() {
    return id;
  }
}
