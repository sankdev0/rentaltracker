package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.dao.PersonDAO;
import com.sankdev.rentaltracker.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

  private PersonDAO personDAO;

  @Autowired
  public PersonServiceImpl(PersonDAO thePersonDAO) {
    personDAO = thePersonDAO;
  }

  @Override
  @Transactional
  public List<Person> findAll() {
    return personDAO.findAll();
  }

  @Override
  @Transactional
  public Person findById(long theId) {
    return personDAO.findById(theId);
  }

  @Override
  @Transactional
  public void save(Person thePerson) {
    personDAO.save(thePerson);
  }

  @Override
  @Transactional
  public void delete(long theId) {
    personDAO.deleteById(theId);
  }
}
