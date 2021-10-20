package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.entity.Person;
import java.util.List;

public interface PersonService {

  List<Person> findAll();

  Person findById(long theId);

  void save(Person thePerson);

  void delete(long theId);

}
