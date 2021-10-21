package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.Rental;
import java.util.List;

public interface RentalDAO {

  List<Rental> findAll();

  Rental findById(long theId);

  void save(Rental theRental);

  void deleteById(long theId);

  List<Rental> findAllVacant();
}
