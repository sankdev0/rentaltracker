package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOJPAImpl implements PersonDAO {

  private EntityManager entityManager;

  @Autowired
  public PersonDAOJPAImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  @Override
  public List<Person> findAll() {
    TypedQuery<Person> theQuery = entityManager.createQuery("from Person", Person.class);

    List<Person> people = theQuery.getResultList();

    return people;
  }

  @Override
  public Person findById(long theId) {

    Person thePerson = entityManager.find(Person.class, theId);

    return thePerson;
  }

  @Override
  public void save(Person thePerson) {

    Person dbPerson = entityManager.merge(thePerson);

    thePerson.setId(dbPerson.getId());
  }

  @Override
  public void deleteById(long theId) {

    Query theQuery = entityManager.createQuery("delete from Person where id=:personId");

    theQuery.setParameter("personId", theId);

    theQuery.executeUpdate();
  }
}
