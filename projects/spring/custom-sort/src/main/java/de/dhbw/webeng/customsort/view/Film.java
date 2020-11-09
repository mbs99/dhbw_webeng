package de.dhbw.webeng.customsort.view;

public class Film {
    private String title;
    private String openingCrawl;
    private String director;

    public Film(String title, String openingCrawl, String director) {
        this.title = title;
        this.openingCrawl = openingCrawl;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
