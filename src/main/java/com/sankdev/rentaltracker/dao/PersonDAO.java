package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.Person;
import java.util.List;

public interface PersonDAO {

  List<Person> findAll();

  Person findById(long theId);

  void save(Person thePerson);

  void deleteById(long theId);

}
