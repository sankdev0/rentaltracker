package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.dao.AgreementDAO;
import com.sankdev.rentaltracker.dao.BaseRateDAO;
import com.sankdev.rentaltracker.entity.Agreement;
import com.sankdev.rentaltracker.entity.BaseRate;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgreementServiceImpl implements AgreementService {

  private AgreementDAO agreementDAO;
  private BaseRateDAO baseRateDAO;

  @Autowired
  public AgreementServiceImpl(AgreementDAO theAgreementDAO, BaseRateDAO theBaseRateDAO) {
    agreementDAO = theAgreementDAO;
    baseRateDAO = theBaseRateDAO;
  }

  @Override
  @Transactional
  public List<Agreement> findAll() {
    return agreementDAO.findAll();
  }

  @Override
  @Transactional
  public BigDecimal getRentalAmount(LocalDate reportDate) {

    BaseRate rate = baseRateDAO.getBaseRate(reportDate);
    BigDecimal result = BigDecimal.valueOf(0);

    if (rate != null) {
      return rate.getRate();
    } else {
      return result;
    }

  }
}
