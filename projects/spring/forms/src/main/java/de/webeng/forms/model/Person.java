package de.webeng.forms.model;

public class Person {
  private String firstName;
  private String lastName;
  private Boolean deletePerson = false;
  private Integer id;
  private static Integer counter = 0;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Boolean getDeletePerson() {
    return deletePerson;
  }

  public void setDeletePerson(Boolean deletePerson) {
    this.deletePerson = deletePerson;
  }

  public Person() {
    this.id = counter++;
  }

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = counter++;
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
