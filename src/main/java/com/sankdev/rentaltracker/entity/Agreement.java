package com.sankdev.rentaltracker.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agreement")
public class Agreement {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @ManyToOne
  @JoinColumn(name = "rental_id")
  private Rental rental;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

  public Agreement() {

  }

  public Agreement(long id, LocalDate date, LocalDate startDate, LocalDate endDate,
      Rental rental, Person person, Company company) {
    this.id = id;
    this.date = date;
    this.startDate = startDate;
    this.endDate = endDate;
    this.rental = rental;
    this.person = person;
    this.company = company;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Rental getRental() {
    return rental;
  }

  public void setRental(Rental rental) {
    this.rental = rental;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  @Override
  public String toString() {
    return "Agreement{" +
        "id=" + id +
        ", date=" + date +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", rental=" + rental +
        ", person=" + person +
        ", company=" + company +
        '}';
  }

  public String getClientName() {
    if (company != null) {
      return company.getName();
    } else if (person != null) {
      return person.getFirstName() + " " + person.getPatronymicName() + " " + person.getLastName();
    } else {
      return "";
    }
  }
}
