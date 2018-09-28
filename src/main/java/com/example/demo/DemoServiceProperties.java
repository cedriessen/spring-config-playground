package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Configuration
@ConfigurationProperties
@PropertySource("file:./etc/demo-service.cfg")
public class DemoServiceProperties {

  // will be null if key missing
  private String weight;

  // will be null if key missing
  private String general;

  // will crash if key missing
  @Value("${value}")
  private String value;

  // will be "default" if key missing
  @Value("${some.special.property:default}")
  private String someSpecialProperty;

  // will be null if key missing
  private Optional<String> optional;

  // will crash if key missing
  @Value("${optional-value}")
  private Optional<String> optionalValue;

  // will be none if key missing
  @Value("${another-optional-value:#{null}}")
  private Optional<String> anotherOptionalValue;

  // will be null if key missing
  @Value("${some-optional-value:#{null}}")
  private String someOptionalValue;

  private DemoServiceProperties dependency;

  //

  public Optional<String> getAnotherOptionalValue() {
    return anotherOptionalValue;
  }

  public void setAnotherOptionalValue(Optional<String> anotherOptionalValue) {
    this.anotherOptionalValue = anotherOptionalValue;
  }

  public String getSomeOptionalValue() {
    return someOptionalValue;
  }

  public void setSomeOptionalValue(String someOptionalValue) {
    this.someOptionalValue = someOptionalValue;
  }

  public Optional<String> getOptionalValue() {
    return optionalValue;
  }

  public void setOptionalValue(Optional<String> optionalValue) {
    this.optionalValue = optionalValue;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Optional<String> getOptional() {
    return optional;
  }

  public void setOptional(Optional<String> optional) {
    this.optional = optional;
  }

  @Autowired
  public void setDependency(DemoServiceProperties dependency) {
    this.dependency = dependency;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getGeneral() {
    return general;
  }

  public void setGeneral(String general) {
    this.general = general;
  }

  public String getSomeSpecialProperty() {
    return someSpecialProperty;
  }

  public void setSomeSpecialProperty(String someSpecialProperty) {
    this.someSpecialProperty = someSpecialProperty;
  }

  @PostConstruct
  public void validate() {
    // some complex validation here
    Log.log("validated using " + dependency);
  }
}
