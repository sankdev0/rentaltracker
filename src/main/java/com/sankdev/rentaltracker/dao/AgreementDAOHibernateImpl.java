package com.sankdev.rentaltracker.dao;

import com.sankdev.rentaltracker.entity.Agreement;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AgreementDAOHibernateImpl implements AgreementDAO {

  private EntityManager entityManager;

  @Autowired
  public AgreementDAOHibernateImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  @Override
  public List<Agreement> findAll() {

    Session currentSession = entityManager.unwrap(Session.class);

    Query<Agreement> theQuery = currentSession.createQuery("from Agreement", Agreement.class);

    return theQuery.getResultList();
  }
}
