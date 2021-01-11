package de.dhbw.webeng.swapitravel;

import de.dhbw.webeng.swapitravel.backend.StarshipModel;
import de.dhbw.webeng.swapitravel.view.MainPage;
import de.dhbw.webeng.swapitravel.view.StarshipViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ViewController {

    private SwapiTravelService swapiTravelService;

    public ViewController(SwapiTravelService swapiTravelService) {
        this.swapiTravelService = swapiTravelService;
    }

    @GetMapping({"/"})
    public String getMainPage(Model model, @ModelAttribute("mainPage")MainPage mainPage) {

        mainPage.setNumPassengers("");
        mainPage.setStarships(new ArrayList<>());

        return "main";
    }

    @PostMapping({"/"})
    public String searchStarship(Model model, @ModelAttribute("mainPage")MainPage mainPage) {

        List<StarshipModel> results = this.swapiTravelService.searchStarships(Integer.parseInt(mainPage.getNumPassengers()));
        mainPage.setStarships(results.stream().map(ship -> {
            StarshipViewModel viewModel = new StarshipViewModel();
            viewModel.setName(ship.name);
            viewModel.setType(ship.model);
            viewModel.setPassengers(ship.passengers);

            return viewModel;
        }).collect(Collectors.toList()));

        return "main";
    }
}
