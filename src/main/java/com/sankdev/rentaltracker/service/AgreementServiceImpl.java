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
  private RentalService rentalService;

  @Autowired
  public AgreementServiceImpl(AgreementDAO theAgreementDAO, RentalService theRentalService) {
    agreementDAO = theAgreementDAO;
    rentalService = theRentalService;
  }

  @Override
  @Transactional
  public List<Agreement> findAll() {
    return agreementDAO.findAll();
  }

  @Override
  @Transactional
  public BigDecimal getRentalAmount(LocalDate reportDate) {

    List<Agreement> agreements = findAll();

    BigDecimal rentalAmount = BigDecimal.valueOf(0);

    for (Agreement tempAgreement : agreements) {
      rentalAmount = rentalAmount.add(
          rentalService.getRentalAmount(tempAgreement.getRental(), reportDate));
    }

    return rentalAmount;
  }
}
