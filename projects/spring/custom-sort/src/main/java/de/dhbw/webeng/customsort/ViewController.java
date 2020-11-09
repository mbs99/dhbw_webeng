package de.dhbw.webeng.customsort;

import de.dhbw.webeng.customsort.model.Film;
import de.dhbw.webeng.customsort.view.FilmsPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ViewController {

    private SwapiSortService swapiSortService;

    public ViewController(SwapiSortService swapiSortService) {
        this.swapiSortService = swapiSortService;
    }

    @GetMapping({"/"})
    public String getFilmsPage(@RequestParam(value = "field", required = false) String field, @RequestParam(value = "sort", required = false) String sort, Model model, @ModelAttribute("filmsPage") FilmsPage filmsPage) {

        if(isParamNullOrEmpty(field) && isParamNullOrEmpty(sort)) {
            return "redirect:/?sort=asc&field=Title";
        } else if(isParamNullOrEmpty(field)) {
            return "redirect:/?sort=" + sort+ "&field=Title";
        } else if(isParamNullOrEmpty(sort)) {
            return "redirect:/?sort=asc&field=" + field;
        }

        List<Film> films = this.swapiSortService.getFilms(sort, field);
        filmsPage.setFilms(films.stream().map(film -> {
            de.dhbw.webeng.customsort.view.Film filmModel = new de.dhbw.webeng.customsort.view.Film(film.getTitle(), film.getOpeningCrawl(), film.getDirector());
            return filmModel;
        }).collect(Collectors.toList()));
        filmsPage.setSortField(field);
        filmsPage.setSort(sort);

        return "films";
    }

    @PostMapping({"/"})
    public String updateSortSettings(@RequestParam(value = "field", required = false) String field, @RequestParam(value = "sort", required = false) String sort, Model model, @ModelAttribute("filmsPage") FilmsPage filmsPage) {

        return "redirect:/?sort=" + filmsPage.getSort() + "&field=" + filmsPage.getSortField();
    }

    private boolean isParamNullOrEmpty(String param) {
        return param == null || param.isEmpty();
    }

}
