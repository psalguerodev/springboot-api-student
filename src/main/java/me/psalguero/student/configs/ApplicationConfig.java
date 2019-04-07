package me.psalguero.student.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@Getter
public class ApplicationConfig {

  @Value("${application.name}")
  private String applicationName;

  @Value("${spring.h2.console.path}")
  private String h2Path;

}
