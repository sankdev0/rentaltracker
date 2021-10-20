package com.sankdev.rentaltracker.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
@Table(name = "rental")
public class Rental {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "type")
  private String type;

  @Column(name = "name")
  private String name;

  @Column(name = "address")
  private String address;

  @Column(name = "room_area")
  private BigDecimal roomArea;

  @Column(name = "basement_area")
  private BigDecimal basementArea;

  @Column(name = "basement_multiplier")
  private BigDecimal basementMultiplier;

  @Column(name = "technical_multiplier")
  private BigDecimal technicalMultiplier;

  // Enable lazy-loading.
  // Block cascading delete (if we delete a rental then DO NOT delete agreements on this rental).
  @OneToMany(mappedBy = "rental", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH,
      CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  private List<Agreement> agreements;

  public Rental() {

  }

  public Rental(long id, String type, String name, String address, BigDecimal roomArea,
      BigDecimal basementArea, BigDecimal basementMultiplier,
      BigDecimal technicalMultiplier,
      List<Agreement> agreements) {
    this.id = id;
    this.type = type;
    this.name = name;
    this.address = address;
    this.roomArea = roomArea;
    this.basementArea = basementArea;
    this.basementMultiplier = basementMultiplier;
    this.technicalMultiplier = technicalMultiplier;
    this.agreements = agreements;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getRoomArea() {
    return roomArea;
  }

  public void setRoomArea(BigDecimal roomArea) {
    this.roomArea = roomArea;
  }

  public BigDecimal getBasementArea() {
    return basementArea;
  }

  public void setBasementArea(BigDecimal basementArea) {
    this.basementArea = basementArea;
  }

  public BigDecimal getBasementMultiplier() {
    return basementMultiplier;
  }

  public void setBasementMultiplier(BigDecimal basementMultiplier) {
    this.basementMultiplier = basementMultiplier;
  }

  public BigDecimal getTechnicalMultiplier() {
    return technicalMultiplier;
  }

  public void setTechnicalMultiplier(BigDecimal technicalMultiplier) {
    this.technicalMultiplier = technicalMultiplier;
  }

  public List<Agreement> getAgreements() {
    return agreements;
  }

  public void setAgreements(List<Agreement> agreements) {
    this.agreements = agreements;
  }

  @Override
  public String toString() {
    return "Rental{" +
        "id=" + id +
        ", type='" + type + '\'' +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", roomArea=" + roomArea +
        ", basementArea=" + basementArea +
        ", basementMultiplier=" + basementMultiplier +
        ", technicalMultiplier=" + technicalMultiplier +
        ", agreements=" + agreements +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rental)) {
      return false;
    }
    Rental rental = (Rental) o;
    return id == rental.id && Objects.equals(type, rental.type) && Objects.equals(
        name, rental.name) && Objects.equals(address, rental.address)
        && Objects.equals(roomArea, rental.roomArea);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, name, address, roomArea);
  }

  // Convenience method for bi-directional relationship.
  public void add(Agreement tempAgreement) {
    if (agreements == null) {
      agreements = new ArrayList<>();
    }

    agreements.add(tempAgreement);

    // THIS sets the bi-directional link between the rental and agreement.
    tempAgreement.setRental(this);
  }
}
