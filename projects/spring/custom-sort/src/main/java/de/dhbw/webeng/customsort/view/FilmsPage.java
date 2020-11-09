package de.dhbw.webeng.customsort.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilmsPage {

    private List<Film> films = new ArrayList<>();
    private String sort;
    private List<String> sortFields = Arrays.asList("Title", "Director");
    private String sortField;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<String> getSortFields() {
        return sortFields;
    }

    public void setSortFields(List<String> sortFields) {
        this.sortFields = sortFields;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }
}
