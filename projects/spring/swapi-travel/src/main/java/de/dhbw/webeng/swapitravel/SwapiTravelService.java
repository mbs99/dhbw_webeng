package de.dhbw.webeng.swapitravel;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.webeng.swapitravel.backend.Results;
import de.dhbw.webeng.swapitravel.backend.StarshipModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SwapiTravelService {

  private final HttpClient httpClient;
  private final ObjectMapper mapper;
  @Value("${swapi.url}")
  private String swapiBaseUrl;

  public SwapiTravelService(HttpClient httpClient, ObjectMapper mapper) {
    this.httpClient = httpClient;
    this.mapper = mapper;
  }

  public List<StarshipModel> searchStarships(Integer numPassenges) {
      List<StarshipModel> allShips = this.getAllStarships();
      return allShips.stream().filter(ship -> {
          boolean match = false;
          if(null != ship.passengers) {
              try {
              match = numPassenges.intValue() <= Integer.parseInt(ship.passengers);
              } catch(NumberFormatException e) {
                  match = false;
              }
          }
          return match;
      }).collect(Collectors.toList());
  }

  private List<StarshipModel> getAllStarships() {
    List<StarshipModel> starships = new ArrayList<>();
    try {
      Results results = null;
      String nextUrl = this.swapiBaseUrl + "starships/";
      do {
        HttpRequest request =
            HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(nextUrl))
                .timeout(Duration.ofMinutes(1))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> rawResponse =
            this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (rawResponse.statusCode() == HttpStatus.OK.value()) {
          results = this.mapper.readValue(rawResponse.body(), Results.class);
          nextUrl = results.next;
          starships.addAll(results.starships);
        }
      } while (results != null && results.next != null);
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return starships;
  }
}
