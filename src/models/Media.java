package models;

import java.util.Set;

public abstract class Media {
    private final int id;
    private final String mediaType;
    private final String title;
    private final int releaseYear;
    private final Set<String> genres;
    private final Location location;

    public Media(int id, String mediaType, String title, int releaseYear, Set<String> genres, Location location){
        this.id = id;
        this.mediaType = mediaType;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.location = location;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public int getReleaseYear(){
        return releaseYear;
    }

    public Set<String> getGenres(){
        return genres;
    }

    public Location getLocation(){
        return location;
    }

}
