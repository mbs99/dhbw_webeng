package de.dhbw.webeng.swapisearch;

import de.dhbw.webeng.swapisearch.model.Planet;
import de.dhbw.webeng.swapisearch.view.PlanetInfo;
import de.dhbw.webeng.swapisearch.view.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class ViewController {

  private final SwapisearchService swapisearchService;

  public ViewController(SwapisearchService swapisearchService) {
    this.swapisearchService = swapisearchService;
  }

  @GetMapping({"/", "/index.html"})
  public String getIndex(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
    searchForm.setResults(new PlanetInfo[] {});
    searchForm.setSearchInput("");
    return "search";
  }

  @PostMapping({"/search"})
  public String getSearchView(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {

    Planet[] planets = this.swapisearchService.findPlanet(searchForm.getSearchInput());
    // Planet[] planets = this.swapisearchService.findPlanetByName(searchForm.getSearchInput());

    PlanetInfo[] planetInfos =
        Arrays.stream(planets)
            .map(
                planet -> {
                  PlanetInfo info = new PlanetInfo();
                  info.name = planet.getName();
                  info.climate = planet.getClimate();
                  info.diameter = planet.getDiameter();
                  info.gravity = planet.getGravity();
                  info.orbital_period = planet.getOrbital_period();
                  info.population = planet.getPopulation();
                  info.rotation_period = planet.getRotation_period();
                  info.surface_water = planet.getSurface_water();
                  info.terrain = planet.getTerrain();
                  return info;
                })
            .collect(Collectors.toList())
            .toArray(new PlanetInfo[] {});

    searchForm.setResults(planetInfos);

    return "search";
  }

  @GetMapping({"/search"})
  public String getPlainSearchView(
      Model model, @ModelAttribute("searchForm") SearchForm searchForm) {

    searchForm.setResults(new PlanetInfo[] {});
    searchForm.setSearchInput("");
    return "search";
  }
}
