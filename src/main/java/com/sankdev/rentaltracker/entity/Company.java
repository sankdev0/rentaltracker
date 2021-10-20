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
@Table(name = "company")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "inn")
  private String inn;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Column(name = "license_number")
  private String licenseNumber;

  @Column(name = "license_date")
  private LocalDate licenseDate;

  @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
      CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Agreement> agreements;

  public Company() {

  }

  public Company(long id, String inn, String name, String address, String licenseNumber,
      LocalDate licenseDate, List<Agreement> agreements) {
    this.id = id;
    this.inn = inn;
    this.name = name;
    this.address = address;
    this.licenseNumber = licenseNumber;
    this.licenseDate = licenseDate;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  public LocalDate getLicenseDate() {
    return licenseDate;
  }

  public void setLicenseDate(LocalDate licenseDate) {
    this.licenseDate = licenseDate;
  }

  public List<Agreement> getAgreements() {
    return agreements;
  }

  public void setAgreements(List<Agreement> agreements) {
    this.agreements = agreements;
  }

  @Override
  public String toString() {
    return "Company{" +
        "id=" + id +
        ", inn='" + inn + '\'' +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", licenseNumber='" + licenseNumber + '\'' +
        ", licenseDate=" + licenseDate +
        ", agreements=" + agreements +
        '}';
  }

  public void add(Agreement tempAgreement) {
    if (agreements == null) {
      agreements = new ArrayList<>();
    }

    agreements.add(tempAgreement);

    tempAgreement.setCompany(this);
  }
}
