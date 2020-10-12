package de.webeng.basicrest.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {
  List<Person> findByLastNameIgnoreCase(String lastName);

  List<Person> findByFirstNameIgnoreCase(String firstName);

  List<Person> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
}
