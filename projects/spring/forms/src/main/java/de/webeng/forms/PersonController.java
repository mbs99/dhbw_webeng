package de.webeng.forms;

import de.webeng.forms.model.Person;
import de.webeng.forms.view.PersonForm;
import de.webeng.forms.view.PersonListForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class PersonController {
  private static List<Person> persons = new ArrayList<>();

  static {
    persons.add(new Person("Bill", "Gates"));
    persons.add(new Person("Steve", "Jobs"));
  }

  @Value("${welcome.message}")
  private String message;

  @Value("${error.message}")
  private String errorMessage;

  @GetMapping(value = {"/", "/index"})
  public String index(Model model) {

    model.addAttribute("message", message);

    return "index";
  }

  @GetMapping(value = {"/personList"})
  public String personList(Model model) {

    PersonListForm personListForm = new PersonListForm();
    personListForm.setPersons(this.persons);

    model.addAttribute("personListForm", personListForm);

    return "list";
  }

  @GetMapping(value = {"/addPerson"})
  public String showAddPersonPage(Model model) {

    PersonForm personForm = new PersonForm();
    model.addAttribute("personForm", personForm);

    return "addPerson";
  }

  @PostMapping(value = {"/addPerson"})
  public String savePerson(Model model, @ModelAttribute("personForm") PersonForm personForm) {

    String firstName = personForm.getFirstName();
    String lastName = personForm.getLastName();

    if (firstName != null
        && firstName.length() > 0 //
        && lastName != null
        && lastName.length() > 0) {
      Person newPerson = new Person(firstName, lastName);
      persons.add(newPerson);

      return "redirect:/personList";
    }

    model.addAttribute("errorMessage", errorMessage);
    return "addPerson";
  }

  @PostMapping(value = {"/deletePerson"})
  public String deletePerson(
      Model model, //
      @ModelAttribute("personListForm") PersonListForm personListForm) {

    List<Integer> idsToDelete =
        personListForm.getPersons().stream()
            .filter(p -> Objects.equals(Boolean.TRUE, p.getDeletePerson()))
            .map(p -> p.getId())
            .collect(Collectors.toList());

    List<Person> personsToDelete =
        PersonController.persons.stream()
            .filter(p -> idsToDelete.stream().anyMatch(id -> Objects.equals(id, p.getId())))
            .collect(Collectors.toList());

    PersonController.persons.removeAll(personsToDelete);

    return "redirect:/personList";
  }
}
