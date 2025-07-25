package models;

import java.util.Set;

public class Book extends Media {
    private final String author;
    private final String publisher;
    private final int pageCount;

    public Book(int id, String mediaType, String title, String author, String publisher, int releaseYear, Set<String> genres, Location location, int pageCount){
        super(id, mediaType, title, releaseYear, genres, location);
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

    public String getAuthor(){
        return author;
    }

    public String getPublisher(){
        return publisher;
    }

    public int getPageCount(){
        return pageCount;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + " | Media Type: " + getClass().getSimpleName() + " | Title: " + getTitle() + " | Author: " + getAuthor() + " | Publisher: " + getPublisher() + " | Release Year: " + getReleaseYear() + " | Genres: " + getGenres() + " | Location: " + getLocation() + " | Page Count: " + getPageCount();
    }
}
