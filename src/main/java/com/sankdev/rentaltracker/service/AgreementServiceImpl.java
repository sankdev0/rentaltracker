package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.dao.AgreementDAO;
import com.sankdev.rentaltracker.entity.Agreement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgreementServiceImpl implements AgreementService {

  private AgreementDAO agreementDAO;

  @Autowired
  public AgreementServiceImpl(AgreementDAO theAgreementDAO) {
    agreementDAO = theAgreementDAO;
  }

  @Override
  @Transactional
  public List<Agreement> findAll() {
    return agreementDAO.findAll();
  }

  @Override
  @Transactional
  public BigDecimal getRentalAmount(LocalDate reportDate) {

    if (reportDate.equals(LocalDate.now())) {
      return BigDecimal.valueOf(12000.00);
    } else {
      return BigDecimal.valueOf(10_000.00);
    }

  }
}
