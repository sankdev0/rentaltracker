package com.sankdev.rentaltracker.utils;

import com.sankdev.rentaltracker.entity.BaseRate;
import java.util.Comparator;

public class RateComparator implements Comparator<BaseRate> {

  @Override
  public int compare(BaseRate o1, BaseRate o2) {
    return o2.getDocumentDate().compareTo(o1.getDocumentDate());
  }
}
