package de.dhbw.webeng.swapisearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.webeng.swapisearch.model.Planet;
import de.dhbw.webeng.swapisearch.model.PlanetSearchResult;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SwapisearchService {

  private final HttpClient httpClient;

  private final ObjectMapper mapper = new ObjectMapper();

  @Value("${swapi.url}")
  private String swapiBaseUrl;

  public SwapisearchService(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  public Planet[] findPlanetByName(String name) {
    try {
      HttpRequest request =
          HttpRequest.newBuilder()
              .GET()
              .uri(new URI(this.swapiBaseUrl + "planets/?search=" + name))
              .timeout(Duration.ofMinutes(1))
              .header("Accept", "application/json")
              .build();
      HttpResponse<String> rawResponse =
          this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      if (rawResponse.statusCode() == HttpStatus.OK.value()) {
        PlanetSearchResult planetSearchResult =
            this.mapper.readValue(rawResponse.body(), PlanetSearchResult.class);
        return planetSearchResult.getResults();
      }
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return new Planet[] {};
  }

  public Planet[] findPlanet(String query) {
    try {
      Planet[] planets = getAllPlanets(new URI(this.swapiBaseUrl + "planets/"));
      return Arrays.stream(planets)
          .filter(planet -> planet.findByQuery(query))
          .collect(Collectors.toList())
          .toArray(new Planet[] {});

    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return new Planet[] {};
  }

  private Planet[] getAllPlanets(URI uri) throws IOException, InterruptedException {
    HttpRequest request =
        HttpRequest.newBuilder()
            .GET()
            .uri(uri)
            .timeout(Duration.ofMinutes(1))
            .header("Accept", "application/json")
            .build();
    HttpResponse<String> rawResponse =
        this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    if (rawResponse.statusCode() == HttpStatus.OK.value()) {
      PlanetSearchResult planetSearchResult =
          this.mapper.readValue(rawResponse.body(), PlanetSearchResult.class);
      // nötig, da Arrays.asList() eine nicht veränderbare Liste liefert...
      List<Planet> planets = new ArrayList<>(Arrays.asList(planetSearchResult.getResults()));
      if (planetSearchResult.getNext() != null) {
        Planet[] partialPlanets = getAllPlanets(URI.create(planetSearchResult.getNext()));
        if (0 != partialPlanets.length) {
          planets.addAll(Arrays.asList(partialPlanets));
        }
      }
      return planets.toArray(new Planet[] {});
    }

    return new Planet[] {};
  }
}
