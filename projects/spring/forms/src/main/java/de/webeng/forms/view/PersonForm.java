package de.webeng.forms.view;

public class PersonForm {
  private String firstName;
  private String lastName;
  private Boolean deletePerson;
  private Integer id;

  public Boolean getDeletePerson() {
    return deletePerson;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
