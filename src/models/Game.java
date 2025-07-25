package models;

import java.util.List;
import java.util.Set;

public class Game extends Media {
    private final String developer;
    private final String publisher;
    private final String platform;
    private final List<String> modes;

    public Game(int id, String mediaType, String title, String developer, String publisher, int releaseYear, Set<String> genres, Location location, String platform, List<String> modes){
        super(id, mediaType, title, releaseYear, genres, location);
        this.developer = developer;
        this.publisher = publisher;
        this.platform = platform;
        this.modes = modes;
    }

    public String getDeveloper(){
        return developer;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getPlatform(){
        return platform;
    }

    public List<String> getModes(){
        return modes;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + " | Media Type: " + getClass().getSimpleName() + " | Title: " + getTitle() + " | Developer: " + getDeveloper() + " | Publisher: " + getPublisher() +  " | Release Year: " + getReleaseYear() + " | Genres: " + getGenres() + " | Location: " + getLocation() + " | Platform: " + getPlatform() + " | Modes: " + getModes();
    }

}
