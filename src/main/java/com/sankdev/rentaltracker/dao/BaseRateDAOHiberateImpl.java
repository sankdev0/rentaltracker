package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.BaseRate;
import com.sankdev.rentaltracker.utils.RateComparator;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseRateDAOHiberateImpl implements BaseRateDAO {

  private EntityManager entityManager;

  @Autowired
  public BaseRateDAOHiberateImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  @Override
  public BaseRate getBaseRate(LocalDate date) {

    Session currentSession = entityManager.unwrap(org.hibernate.Session.class);

    Query<BaseRate> theQuery
        = currentSession.createQuery("from BaseRate", BaseRate.class);

    List<BaseRate> rates = theQuery.getResultList();

    Collections.sort(rates, new RateComparator());

    rates.removeIf(x -> x.getDocumentDate().isAfter(date));

    Optional<BaseRate> result = rates.stream().findFirst();

    if(result.isPresent()) {
      return result.get();
    } else {
      return null;
    }
  }
}
