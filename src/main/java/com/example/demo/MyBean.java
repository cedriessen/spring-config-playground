package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyBean extends AbstractBean {
  public MyBean(
      @Value("${values.string:}") String string,
      @Value("#{ '${values.string:}'.empty }") boolean bool,
      @Value("0.3") float floatValue) {
    Log.log("string", string);
    Log.log("empty", bool);
    Log.log("float", floatValue);
  }

  @Override
  public void shutdown() {
    super.shutdown();
    Log.log("overridden shutdown");
  }

  @PostConstruct
  public void setup() {
    Log.log("setup");
    Log.log("someBoolean", someBoolean);
  }

  @PreDestroy
  public void destroy() {
    Log.log("destroy");
  }
}
