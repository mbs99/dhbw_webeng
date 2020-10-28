package de.dhbw.webeng.swapipagination;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;

@Configuration
@EnableCaching
public class SwapiPaginationConfig {
  @Bean
  public HttpClient getDefaultHttpClient() {
    return HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
  }
}
