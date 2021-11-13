package com.promineotech.jeep.controller.support;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import lombok.Getter;

public class BaseTest {
  @Autowired
  @Getter
  private TestRestTemplate restTemplate;

  @LocalServerPort
  private int serverPort;

  protected String getBaseUriForJeeps() {
    return String.format("http://localhost:%d/jeeps", serverPort);
  }
  

  protected String getBaseUriForOrders() {
    return String.format("http://localhost:%d/orders", serverPort);
  }
}
