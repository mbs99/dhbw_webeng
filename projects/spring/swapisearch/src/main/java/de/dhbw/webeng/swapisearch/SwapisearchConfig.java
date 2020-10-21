package de.dhbw.webeng.swapisearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
public class SwapisearchConfig {

  @Bean
  public HttpClient getDefaultHttpClient() {
    return HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
  }
}
