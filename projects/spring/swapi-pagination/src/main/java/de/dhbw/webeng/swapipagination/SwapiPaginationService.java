package de.dhbw.webeng.swapipagination;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.webeng.swapipagination.model.People;
import de.dhbw.webeng.swapipagination.model.Planet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class SwapiPaginationService {

  @Value("${swapi.url}")
  private String swapiBaseUrl;

  private final HttpClient httpClient;
  private final ObjectMapper mapper;

  public SwapiPaginationService(HttpClient httpClient, ObjectMapper mapper) {
    this.httpClient = httpClient;
    this.mapper = mapper;
  }

  @Cacheable("planets")
  public Planet getPlanetById(int id) {
    try {
      HttpRequest request =
          HttpRequest.newBuilder()
              .GET()
              .uri(new URI(this.swapiBaseUrl + "planets/" + id + "/"))
              .timeout(Duration.ofMinutes(1))
              .header("Accept", "application/json")
              .build();
      HttpResponse<String> rawResponse =
          this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      if (rawResponse.statusCode() == HttpStatus.OK.value()) {
        Planet planetById = this.mapper.readValue(rawResponse.body(), Planet.class);

        return planetById;
      }
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return null;
  }

  public People getPeopleByUrl(String url) {
    try {
      HttpRequest request =
          HttpRequest.newBuilder()
              .GET()
              .uri(new URI(url))
              .timeout(Duration.ofMinutes(1))
              .header("Accept", "application/json")
              .build();
      HttpResponse<String> rawResponse =
          this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      if (rawResponse.statusCode() == HttpStatus.OK.value()) {
        People people = this.mapper.readValue(rawResponse.body(), People.class);

        return people;
      }
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Cacheable("people")
  public People getPeopleById(int id) {

    return this.getPeopleByUrl(this.swapiBaseUrl + "people/" + id + "/");
  }
}
