package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;

public abstract class AbstractBean {
  @Value("${some_boolean:true}")
  protected boolean someBoolean;

  @PreDestroy
  public void shutdown() {
    System.out.println("shutdown");
  }
}
