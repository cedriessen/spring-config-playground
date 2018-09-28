package com.example.demo;

public class Log {
  public static void log(String key, String value) {
    if (value != null) {
      System.out.println(getCaller() + ": " + key + " = '" + value + "'");
    } else {
      System.out.println(getCaller() + ": " + key + " = <null>");
    }
  }

  public static void log(String key, Object value) {
    if (value != null) {
      System.out.println(getCaller() + ": " + key + " = " + value);
    } else {
      System.out.println(getCaller() + ": " + key + " = <null>");
    }
  }

  public static void log(Object instance, String value) {
    log(instance.getClass().getSimpleName(), value);
  }

  public static void log(Object instance, Object value) {
    log(instance.getClass().getSimpleName(), value);
  }

  public static void log(String message) {
    System.out.println(getCaller() + ": " + message);
  }

  public static String getCaller() {
    return new RuntimeException().getStackTrace()[2].getClassName();
  }
}
