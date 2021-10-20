package com.sankdev.rentaltracker.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "inn")
  private String inn;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "patronymic_name")
  private String patronymicName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "serial")
  private String serial;

  @Column(name = "number")
  private String number;

  @Column(name = "issue_date")
  private LocalDate issueDate;

  @Column(name = "issuer")
  private String issuer;

  @Column(name = "address")
  private String address;

  @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
      CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Agreement> agreements;

  public Person() {

  }

  public Person(long id, String inn, String firstName, String patronymicName,
      String lastName, String serial, String number, LocalDate issueDate, String issuer,
      String address, List<Agreement> agreements) {
    this.id = id;
    this.inn = inn;
    this.firstName = firstName;
    this.patronymicName = patronymicName;
    this.lastName = lastName;
    this.serial = serial;
    this.number = number;
    this.issueDate = issueDate;
    this.issuer = issuer;
    this.address = address;
    this.agreements = agreements;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getInn() {
    return inn;
  }

  public void setInn(String inn) {
    this.inn = inn;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPatronymicName() {
    return patronymicName;
  }

  public void setPatronymicName(String patronymicName) {
    this.patronymicName = patronymicName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getSerial() {
    return serial;
  }

  public void setSerial(String serial) {
    this.serial = serial;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Agreement> getAgreements() {
    return agreements;
  }

  public void setAgreements(List<Agreement> agreements) {
    this.agreements = agreements;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", inn='" + inn + '\'' +
        ", firstName='" + firstName + '\'' +
        ", patronymicName='" + patronymicName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", serial='" + serial + '\'' +
        ", number='" + number + '\'' +
        ", issueDate=" + issueDate +
        ", issuer='" + issuer + '\'' +
        ", address='" + address + '\'' +
        ", agreements=" + agreements +
        '}';
  }

  // Convenience method.
  public void add(Agreement tempAgreement) {

    if (agreements == null) {
      agreements = new ArrayList<>();
    }

    agreements.add(tempAgreement);

    tempAgreement.setPerson(this);
  }

}
