package de.dhbw.webeng.swapipagination;

import de.dhbw.webeng.swapipagination.model.People;
import de.dhbw.webeng.swapipagination.model.Planet;
import de.dhbw.webeng.swapipagination.view.PeoplePage;
import de.dhbw.webeng.swapipagination.view.PlanetPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
public class ViewController {

  private final Pattern idPattern = Pattern.compile(".*(\\/(\\d*)\\/)");
  private final SwapiPaginationService swapiPaginationService;

  public ViewController(SwapiPaginationService swapiPaginationService) {
    this.swapiPaginationService = swapiPaginationService;
  }

  @RequestMapping({"/", "index.html"})
  public String getInitialPlanetPage(
      Model model, @ModelAttribute("planetPage") PlanetPage planetPage) {

    return "redirect:/planet?id=1";
  }

  @RequestMapping({"/planet", "planet.html"})
  public String getPlanetPage(
      @RequestParam(value = "id", required = false, defaultValue = "1") Integer id,
      Model model,
      @ModelAttribute("planetPage") PlanetPage planetPage) {

    Planet planet = this.swapiPaginationService.getPlanetById(id.intValue());
    if (null != planet) {
      this.mapPlanetToPlanetPage(planetPage, planet);

      planetPage.planetId = id.intValue();
      int nextId = id.intValue() + 1;
      if (null == this.swapiPaginationService.getPlanetById(nextId)) {
        planetPage.nextId = -1;
      } else {
        planetPage.nextId = nextId;
      }

      int previousId = id.intValue() - 1;
      if (previousId < 1 || null == this.swapiPaginationService.getPlanetById(previousId)) {
        planetPage.previousId = -1;
      } else {
        planetPage.previousId = previousId;
      }
    }

    return "planet";
  }

  private void mapPlanetToPlanetPage(PlanetPage planetPage, Planet planet) {
    planetPage.name = planet.getName();
    planetPage.climate = planet.getClimate();
    planetPage.diameter = planet.getDiameter();
    planetPage.gravity = planet.getGravity();
    planetPage.orbital_period = planet.getOrbital_period();
    planetPage.population = planet.getPopulation();
    planetPage.rotation_period = planet.getRotation_period();
    planetPage.surface_water = planet.getSurface_water();
    planetPage.terrain = planet.getTerrain();

    List<People> residents =
        Arrays.stream(planet.getResidents())
            .map(resident -> this.swapiPaginationService.getPeopleByUrl(resident))
            .collect(Collectors.toList());
    planetPage.residents = new LinkedHashMap<>();
    residents.forEach(
        resident -> {
          Integer id = getIdFromUrl(resident.getUrl());
          if (null != id) {
            planetPage.residents.put(resident.getName(), id.toString());
          }
        });
  }

  @RequestMapping({"/people", "people.html"})
  public String getPeoplePage(
      @RequestParam(value = "id", required = false, defaultValue = "1") Integer id,
      Model model,
      @ModelAttribute("peoplePage") PeoplePage peoplePage) {

    People people = this.swapiPaginationService.getPeopleById(id.intValue());
    if (null != people) {
      this.mapPeopleToPeoplePage(peoplePage, people);

      peoplePage.peopleId = id.intValue();
      int nextId = id.intValue() + 1;
      if (null == this.swapiPaginationService.getPeopleById(nextId)) {
        peoplePage.nextId = -1;
      } else {
        peoplePage.nextId = nextId;
      }

      int previousId = id.intValue() - 1;
      if (previousId < 1 || null == this.swapiPaginationService.getPeopleById(previousId)) {
        peoplePage.previousId = -1;
      } else {
        peoplePage.previousId = previousId;
      }
    }

    return "people";
  }

  private void mapPeopleToPeoplePage(PeoplePage peoplePage, People people) {
    peoplePage.name = people.getName();

    Integer planetId = getIdFromUrl(people.getHomeworld());
    if (null != planetId) {
      Planet planet = this.swapiPaginationService.getPlanetById(planetId.intValue());
      if (null != planet) {
        peoplePage.planetName = planet.getName();
        peoplePage.planetId = planetId.intValue();
      }
    }
  }

  private Integer getIdFromUrl(String url) {
    Matcher matcher = idPattern.matcher(url);
    if (matcher.find()) {
      String id = matcher.group(2);
      return Integer.parseInt(id);
    }

    return null;
  }
}
