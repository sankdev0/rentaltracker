package com.sankdev.rentaltracker.service;

import com.sankdev.rentaltracker.dao.CompanyRepository;
import com.sankdev.rentaltracker.entity.Company;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepository companyRepository;

  @Autowired
  public CompanyServiceImpl(CompanyRepository theCompanyRepository) {
    companyRepository = theCompanyRepository;
  }

  @Override
  public List<Company> findAll() {
    return companyRepository.findAll();
  }

  @Override
  public Company findById(long theId) {

    Optional<Company> result = companyRepository.findById(theId);

    if (result.isPresent()) {
      return result.get();
    } else {
      throw new RuntimeException("Did not find the company id - " + theId);
    }
  }

  @Override
  public void save(Company theCompany) {
    companyRepository.save(theCompany);
  }

  @Override
  public void delete(long theId) {
    companyRepository.deleteById(theId);
  }
}
