package com.sankdev.rentaltracker.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_rate")
public class BaseRate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Column(name = "document_number")
  private String documentNumber;

  @Column(name = "document_date")
  private LocalDate documentDate;

  @Column(name = "rate")
  private BigDecimal rate;

  public BaseRate() {

  }

  public BaseRate(long id, String documentNumber, LocalDate documentDate, BigDecimal rate) {
    this.id = id;
    this.documentNumber = documentNumber;
    this.documentDate = documentDate;
    this.rate = rate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public LocalDate getDocumentDate() {
    return documentDate;
  }

  public void setDocumentDate(LocalDate documentDate) {
    this.documentDate = documentDate;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  @Override
  public String toString() {
    return "BaseRate{" +
        "id=" + id +
        ", documentNumber='" + documentNumber + '\'' +
        ", documentDate=" + documentDate +
        ", rate=" + rate +
        '}';
  }
}
