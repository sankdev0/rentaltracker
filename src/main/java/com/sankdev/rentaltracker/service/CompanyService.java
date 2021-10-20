package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.entity.Company;
import java.util.List;

public interface CompanyService {

  List<Company> findAll();

  Company findById(long theId);

  void save(Company theCompany);

  void delete(long theId);

}
