package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.Agreement;
import com.sankdev.rentaltracker.entity.Rental;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
// Transactions are handled at the service layer
public class RentalDAOHibernateImpl implements RentalDAO {

  // define field for EntityManager
  private final EntityManager entityManager;

  @Autowired
  // here entityManager is automatically created by the spring container
  public RentalDAOHibernateImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Rental> findAll() {

    Session session = entityManager.unwrap(Session.class);

    Query<Rental> query = session.createQuery("from Rental", Rental.class);

    List<Rental> rentals = query.getResultList();

    return rentals;
  }

  @Override
  public Rental findById(long theId) {

    Session currentSession = entityManager.unwrap(Session.class);

    Rental theRental = currentSession.get(Rental.class, theId);

    return theRental;
  }

  @Override
  public void save(Rental theRental) {

    Session currentSession = entityManager.unwrap(Session.class);

    currentSession.saveOrUpdate(theRental);
  }

  @Override
  public void deleteById(long theId) {

    Session currentSession = entityManager.unwrap(Session.class);

    Query<Rental> theQuery = currentSession.createQuery("delete from Rental where id=:rentalId");
    theQuery.setParameter("rentalId", theId);

    theQuery.executeUpdate();
  }

  @Override
  public List<Rental> findAllVacant() {
    Session session = entityManager.unwrap(Session.class);

    Query<Rental> query = session.createQuery("from Rental", Rental.class);
    List<Rental> rentals = query.getResultList();

    Query<Agreement> agreementsQuery = session.createQuery("from Agreement", Agreement.class);
    List<Agreement> agreements = agreementsQuery.getResultList();

    List<Rental> unoccupiedRentals = new ArrayList<>();
    for (Rental tempRental : rentals) {
      boolean occupied = false;
      for (Agreement tempAgreement : agreements) {
        occupied = false;
        if (tempAgreement.getRental().equals(tempRental)) {
          occupied = true;
          break;
        }
      }
      if (!occupied) {
        unoccupiedRentals.add(tempRental);
      }
    }

    return unoccupiedRentals;
  }
}
