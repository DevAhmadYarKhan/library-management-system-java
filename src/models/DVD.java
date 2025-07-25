package models;

import java.util.Set;

public class DVD extends Media {
    private final String director;
    private final String studio;
    private final Set<String> languages;
    private final int durationMinutes;

    public DVD(int id, String mediaType, String title, String director, String studio, int releaseYear, Set<String> genres, Location location, Set<String> languages, int durationMinutes){
        super(id, mediaType, title, releaseYear, genres, location);
        this.director = director;
        this.studio = studio;
        this.languages = languages;
        this.durationMinutes = durationMinutes;
    }

    public String getDirector(){
        return director;
    }

    public String getStudio(){
        return studio;
    }

    public Set<String> getLanguages(){
        return languages;
    }

    public int getDurationMinutes(){
        return durationMinutes;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + " | Media Type: " + getClass().getSimpleName() + " | Title: " + getTitle() + " | Director: " + getDirector() + " | Studio: " + getStudio() + " | Release Year: " + getReleaseYear() + " | Genres: " + getGenres() + " | Location: " + getLocation() + " | Languages: " + getLanguages() +  " | Duration in minutes: " + getDurationMinutes();
    }

}
