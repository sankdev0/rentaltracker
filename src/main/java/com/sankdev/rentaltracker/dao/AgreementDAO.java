package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.Agreement;
import java.util.List;

public interface AgreementDAO {

  List<Agreement> findAll();
}
