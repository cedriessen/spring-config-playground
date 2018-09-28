package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class DemoService {
  public DemoService(DemoServiceProperties properties) {
    Log.log("weight", properties.getWeight());
    Log.log("general", properties.getGeneral());
    Log.log("someSpecialProperty", properties.getSomeSpecialProperty());
    Log.log("optional", properties.getOptional());
    Log.log("value", properties.getValue());
    Log.log("optionalValue", properties.getOptionalValue());
    Log.log("anotherOptionalValue", properties.getAnotherOptionalValue());
    Log.log("someOptionalValue", properties.getSomeOptionalValue());
  }
}
