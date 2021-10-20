package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
