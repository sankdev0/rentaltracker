package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.dao.BaseRateDAO;
import com.sankdev.rentaltracker.dao.RentalDAO;
import com.sankdev.rentaltracker.entity.BaseRate;
import com.sankdev.rentaltracker.entity.Rental;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentalServiceImpl implements RentalService {

  private RentalDAO rentalDAO;
  private BaseRateDAO baseRateDAO;

  @Autowired
  public RentalServiceImpl(RentalDAO theRentalDAO, BaseRateDAO theBaseRateDAO) {
    rentalDAO = theRentalDAO;
    baseRateDAO = theBaseRateDAO;
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

  @Override
  public BigDecimal getRentalAmount(Rental rental, LocalDate date) {
    //МАП
    // = (базовая ставка/12 * площадь помещения
    // + базовая ставка/12 * площадь подвала * коэффициент подвала) * КТ
    BaseRate baseRate = baseRateDAO.getBaseRate(date);

    double baseRateValue = 0;

    if (baseRate != null) {
      baseRateValue = baseRate.getRate().doubleValue();
    }

    double roomArea = rental.getRoomArea().doubleValue();
    double basementArea = rental.getBasementArea().doubleValue();
    double basementMultiplier = rental.getBasementMultiplier().doubleValue();
    double technicalMultiplier = rental.getTechnicalMultiplier().doubleValue();

    double rentalAmountValue
        = ((baseRateValue * roomArea + baseRateValue * basementArea * basementMultiplier) / 12)
        * technicalMultiplier;

    return BigDecimal.valueOf(rentalAmountValue);
  }
}
