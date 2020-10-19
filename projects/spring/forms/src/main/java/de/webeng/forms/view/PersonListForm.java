package de.webeng.forms.view;

import de.webeng.forms.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonListForm {
  private List<Person> persons = new ArrayList<>();

  public List<Person> getPersons() {
    return persons;
  }

  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }
}
