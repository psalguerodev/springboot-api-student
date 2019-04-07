package me.psalguero.student.configs;

import me.psalguero.student.repositories.UserRepository;
import me.psalguero.student.services.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private ApplicationConfig applicationConfig;

  @Autowired
  private CustomUserDetailsService customUserDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http
        .authorizeRequests()
        .antMatchers("**/api/**").authenticated()
        .and()
        .cors()
        .and()
        .httpBasic();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    auth
        .userDetailsService(customUserDetailsService)
        .passwordEncoder(passwordEncoder);

    auth
        .inMemoryAuthentication()
        .withUser("psalguero1")
        .password(passwordEncoder.encode("psalguero1")).roles("USER")
        .and()
        .withUser("root")
        .password(passwordEncoder.encode("root")).roles("ADMIN");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web
        .ignoring()
        .antMatchers(ConstantsConfig.BASE_PATH + ConstantsConfig.PUBLIC_MAIN_PATH)
        .antMatchers(applicationConfig.getH2Path() + "/**");
  }

  @Bean("corsFilter")
  public CorsFilter corsFilter(ApplicationContext context) {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*");
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
    corsConfiguration.addAllowedMethod(HttpMethod.GET);
    corsConfiguration.addAllowedMethod(HttpMethod.POST);
    corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
    corsConfiguration.addAllowedMethod(HttpMethod.PUT);
    corsConfiguration.addAllowedMethod(HttpMethod.PATCH);

    UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
    corsConfigurationSource.registerCorsConfiguration("/oauth/**", corsConfiguration);
    corsConfigurationSource.registerCorsConfiguration("/api/**", corsConfiguration);

    return new MyCorsFilter(corsConfigurationSource);
  }

  @Order(Ordered.HIGHEST_PRECEDENCE)
  public static class MyCorsFilter extends CorsFilter {
    MyCorsFilter(CorsConfigurationSource configurationSource) {
      super(configurationSource);
    }
  }
}


