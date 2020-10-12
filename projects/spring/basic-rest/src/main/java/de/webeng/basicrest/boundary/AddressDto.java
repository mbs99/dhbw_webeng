package de.webeng.basicrest.boundary;

import de.webeng.basicrest.entity.Address;

public class AddressDto {
  private final String zip;
  private final String city;
  private final String street;

  public AddressDto(String zip, String city, String street) {
    this.zip = zip;
    this.city = city;
    this.street = street;
  }

  public String getZip() {
    return zip;
  }

  public String getCity() {
    return city;
  }

  public String getStreet() {
    return street;
  }

  public static AddressDto from(Address address) {
    return new AddressDto(address.zip, address.city, address.street);
  }
}
