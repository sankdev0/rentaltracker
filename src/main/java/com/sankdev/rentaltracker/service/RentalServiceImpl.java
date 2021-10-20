package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.dao.RentalDAO;
import com.sankdev.rentaltracker.entity.Rental;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentalServiceImpl implements RentalService {

  private RentalDAO rentalDAO;

  @Autowired
  public RentalServiceImpl(RentalDAO theRentalDAO) {
    rentalDAO = theRentalDAO;
  }

  @Override
  @Transactional
  public List<Rental> findAll() {
    return rentalDAO.findAll();
  }

  @Override
  @Transactional
  public Rental findById(long theId) {
    return rentalDAO.findById(theId);
  }

  @Override
  @Transactional
  public void save(Rental theRental) {
    rentalDAO.save(theRental);
  }

  @Override
  @Transactional
  public void deleteById(long theId) {
    rentalDAO.deleteById(theId);
  }

  @Override
  @Transactional
  public List<Rental> findAllVacant() {
    return rentalDAO.findAllVacant();
  }
}
