package de.webeng.basicrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue
  @Column(name = "address_pk")
  public Long id;

  @Column(name = "person_fk")
  public Long personFk;

  @Column(name = "zip", nullable = false)
  public String zip;

  @Column(name = "city", nullable = false)
  public String city;

  @Column(name = "street", nullable = false)
  public String street;
}
