package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.BaseRate;
import java.time.LocalDate;

public interface BaseRateDAO {

  BaseRate getBaseRate(LocalDate date);
}
