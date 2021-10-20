package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.entity.Rental;
import java.util.List;

public interface RentalService {

  List<Rental> findAll();

  Rental findById(long theId);

  void save(Rental theRental);

  void deleteById(long theId);

  List<Rental> findAllVacant();
}
