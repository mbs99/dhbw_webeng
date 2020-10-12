package de.webeng.basicrest.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
  @Id @GeneratedValue public Long id;

  @Column(name = "first_name", nullable = false)
  public String firstName;

  @Column(name = "last_name", nullable = false)
  public String lastName;

  @OneToMany(mappedBy = "personFk")
  public List<Address> addresses;
}
