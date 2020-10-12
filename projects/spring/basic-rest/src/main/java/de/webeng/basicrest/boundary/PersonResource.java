package de.webeng.basicrest.boundary;

import de.webeng.basicrest.entity.Person;
import de.webeng.basicrest.entity.PersonRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/person")
public class PersonResource {

  private final PersonRepo repo;

  public PersonResource(PersonRepo repo) {
    this.repo = repo;
  }

  @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void createPerson(@RequestBody PersonDto personDto) {

    Person person = new Person();
    person.firstName = personDto.getName().getFirstName();
    person.lastName = personDto.getName().getLastName();
    this.repo.save(person);
  }

  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PersonDto>> findPersonJson(
      @RequestParam(name = "lastName", required = false) String lastName,
      @RequestParam(name = "firstName", required = false) String firstName) {

    return new ResponseEntity<>(findPerson(firstName, lastName), HttpStatus.OK);
  }

  @GetMapping(path = "", produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<PersonListDto> findPersonXml(
      @RequestParam(name = "lastName", required = false) String lastName,
      @RequestParam(name = "firstName", required = false) String firstName) {

    return new ResponseEntity<>(new PersonListDto(findPerson(firstName, lastName)), HttpStatus.OK);
  }

  private List<PersonDto> findPerson(
      @RequestParam(name = "lastName", required = false) String lastName,
      @RequestParam(name = "firstName", required = false) String firstName) {
    if (isNullOrEmpty(lastName) && isNullOrEmpty(firstName)) {
      List<PersonDto> result =
          this.repo.findAll().stream()
              .map(person -> PersonDto.from(person))
              .collect(Collectors.toList());
      return result;
    } else {
      List<PersonDto> result = new ArrayList<>();
      if (isNullOrEmpty(firstName)) {
        result =
            this.repo.findByLastNameIgnoreCase(lastName).stream()
                .map(person -> PersonDto.from(person))
                .collect(Collectors.toList());
      } else if (isNullOrEmpty(lastName)) {
        result =
            this.repo.findByFirstNameIgnoreCase(firstName).stream()
                .map(person -> PersonDto.from(person))
                .collect(Collectors.toList());
      } else {
        result =
            this.repo.findByFirstNameAndLastNameIgnoreCase(firstName, lastName).stream()
                .map(person -> PersonDto.from(person))
                .collect(Collectors.toList());
      }
      return result;
    }
  }

  private boolean isNullOrEmpty(String param) {
    return param == null || param.isEmpty() || param.isBlank();
  }
}
