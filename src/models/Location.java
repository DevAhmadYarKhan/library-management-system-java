package models;

public class Location {
    private final String branch;
    private final String section;
    private final String shelf;
    private final String floor;

    public Location(String branch, String section, String shelf, String floor){
        this.branch = branch;
        this.section = section;
        this.shelf = shelf;
        this.floor = floor;
    }

    public String getBranch(){
        return branch;
    }

    public String getSection(){
        return section;
    }

    public String getShelf(){
        return shelf;
    }

    public String getFloor(){
        return floor;
    }

    @Override
    public String toString(){
        return "Branch -> " + branch + ", Section -> " + section + ", Shelf -> " + shelf + ", Floor -> " + floor;
    }

}
