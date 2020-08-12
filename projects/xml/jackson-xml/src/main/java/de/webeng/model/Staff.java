package de.webeng.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Staff {
  @JsonProperty("firstname")
  private String firstName;
  @JsonProperty("lastname")
  private String lastName;
  @JsonProperty("nickname")
  private String nickName;
  @JsonProperty("salary")
  private Double salary;

  public Staff() {
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

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Staff{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", nickName='" + nickName + '\'' +
            ", salary=" + salary +
            '}';
  }
}
