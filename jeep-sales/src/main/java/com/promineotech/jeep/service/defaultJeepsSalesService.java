package com.promineotech.jeep.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.jeep.dao.JeepSalesDao;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class defaultJeepsSalesService implements JeepSalesService {
  
  @Autowired
  private JeepSalesDao jeepSalesDao;

  @Transactional(readOnly = true)
  public List<Jeep> fetchJeeps(JeepModel model, String trim) {
    log.info("The fetchJeeps method was called with model={} and trim ={}", model, trim);
   
    List<Jeep> jeeps = jeepSalesDao.fetchJeeps(model, trim);
    
    if(jeeps.isEmpty()){
      String msg = String.format("NO Jeeps found with model =%s and trim = %s", model, trim);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(jeeps);
    return jeeps;
  }

}
