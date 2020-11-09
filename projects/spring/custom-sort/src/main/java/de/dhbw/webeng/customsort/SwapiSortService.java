package de.dhbw.webeng.customsort;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.webeng.customsort.model.Film;
import de.dhbw.webeng.customsort.model.FilmList;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SwapiSortService {

  @Value("${swapi.url}")
  private String swapiBaseUrl;

  private final HttpClient httpClient;
  private final ObjectMapper mapper;

  public SwapiSortService(HttpClient httpClient, ObjectMapper mapper) {
    this.httpClient = httpClient;
    this.mapper = mapper;
  }

  public List<Film> getFilms(String sort, String field) {
    try {
      HttpRequest request =
          HttpRequest.newBuilder()
              .GET()
              .uri(new URI(this.swapiBaseUrl + "films/"))
              .timeout(Duration.ofMinutes(1))
              .header("Accept", "application/json")
              .build();
      HttpResponse<String> rawResponse =
          this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
      if (rawResponse.statusCode() == HttpStatus.OK.value()) {
        FilmList films = this.mapper.readValue(rawResponse.body(), FilmList.class);

        List<Film> sortedFilms = films.getFilms();
        if("Title".equalsIgnoreCase(field)) {
          sortedFilms = films.getFilms().stream().sorted(Comparator.comparing(Film::getTitle)).collect(Collectors.toList());
        } else if("Director".equalsIgnoreCase(field)) {
          sortedFilms = films.getFilms().stream().sorted(Comparator.comparing(Film::getDirector)).collect(Collectors.toList());
        }

        if("desc".equalsIgnoreCase(sort)) {
          Collections.reverse(sortedFilms);
        }
        return sortedFilms;
      }
    } catch (URISyntaxException | IOException | InterruptedException e) {
      e.printStackTrace();
    }

    return null;
  }
}
