package me.psalguero.student.utils;

import java.io.IOException;

public class FormatUtil {


  public static final String fromObjectToJson(Object object) {
    String json = "";
    com.fasterxml.jackson.databind.ObjectMapper mapper = null;
    mapper = new com.fasterxml.jackson.databind.ObjectMapper();
    try {
      if (object == null) {
        throw new IOException("FormatUtil.fromObjectToJson: Object is null");
      }
      json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    } catch (IOException ignored) {
    }
    return json;
  }
}
