package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.entity.Agreement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface AgreementService {

  List<Agreement> findAll();

  BigDecimal getRentalAmount(LocalDate reportDate);

}
