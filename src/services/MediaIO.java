package services;

import models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class MediaIO {
    public void readMedia(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        String curline;
        while(input.hasNextLine()){
            curline = input.nextLine();
            String[] temp = curline.split("\t");
            if (temp[1].equalsIgnoreCase("Book")){
                Set<String> genres = new HashSet<>();
                Location location = null;
                for (String item : temp){
                    if (item.equals(temp[6])){
                        StringBuilder sb = new StringBuilder(item);
                        sb.deleteCharAt(0);
                        sb.deleteCharAt(sb.length()-1);
                        String[] temp1 = sb.toString().split(", ");
                        for (String item1 : temp1){
                            genres.add(item1);
                        }
                    }
                    else if(item.equals(temp[7])){
                        item = item.replace("Branch -> ", "");
                        item = item.replace(" Section -> ", "");
                        item = item.replace(" Shelf -> ", "");
                        item = item.replace(" Floor -> ", "");
                        String[] temp1 = item.split(",");
                        location = new Location(temp1[0], temp1[1], temp1[2], temp1[3]);
                    }
                }
                Library.getItems().put(Integer.parseInt(temp[0]), new Book(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), genres, location, Integer.parseInt(temp[8])));
            }
            else if(temp[1].equalsIgnoreCase("DVD")){
                Set<String> genres = new HashSet<>();
                Location location = null;
                Set<String> languages = new HashSet<>();
                for (String item : temp){
                    if (item.equals(temp[6])) {
                        StringBuilder sb = new StringBuilder(item);
                        sb.deleteCharAt(0);
                        sb.deleteCharAt(sb.length() - 1);
                        String[] temp1 = sb.toString().split(", ");
                        for (String item1 : temp1){
                            genres.add(item1);
                        }
                    }
                    else if(item.equals(temp[7])){
                        item = item.replace("Branch -> ", "");
                        item = item.replace(" Section -> ", "");
                        item = item.replace(" Shelf -> ", "");
                        item = item.replace(" Floor -> ", "");
                        String[] temp1 = item.split(",");
                        location = new Location(temp1[0], temp1[1], temp1[2], temp1[3]);
                    }
                    else if (item.equals(temp[8])) {
                        StringBuilder sb = new StringBuilder(item);
                        sb.deleteCharAt(0);
                        sb.deleteCharAt(sb.length() - 1);
                        String[] temp1 = sb.toString().split(", ");
                        for (String item1 : temp1){
                            languages.add(item1);
                        }
                    }
                }
                Library.getItems().put(Integer.parseInt(temp[0]), new DVD(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), genres, location, languages, Integer.parseInt(temp[9])));
            }
            else if(temp[1].equalsIgnoreCase("Game")){
                Set<String> genres = new HashSet<>();
                Location location = null;
                List<String> modes = new ArrayList<>();
                for (String item : temp){
                    if (item.equals(temp[6])) {
                        StringBuilder sb = new StringBuilder(item);
                        sb.deleteCharAt(0);
                        sb.deleteCharAt(sb.length() - 1);
                        String[] temp1 = sb.toString().split(", ");
                        for (String item1 : temp1){
                            genres.add(item1);
                        }
                    }
                    else if(item.equals(temp[7])){
                        item = item.replace("Branch -> ", "");
                        item = item.replace(" Section -> ", "");
                        item = item.replace(" Shelf -> ", "");
                        item = item.replace(" Floor -> ", "");
                        String[] temp1 = item.split(",");
                        location = new Location(temp1[0], temp1[1], temp1[2], temp1[3]);
                    }
                    else if (item.equals(temp[9])) {
                        StringBuilder sb = new StringBuilder(item);
                        sb.deleteCharAt(0);
                        sb.deleteCharAt(sb.length() - 1);
                        String[] temp1 = sb.toString().split(", ");
                        for (String item1 : temp1){
                            modes.add(item1);
                        }
                    }
                }
                Library.getItems().put(Integer.parseInt(temp[0]), new Game(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]), genres, location, temp[8], modes));
            }
        }
        input.close();
    }

    public void writeMedia(String filename) throws FileNotFoundException{
        PrintStream output = new PrintStream(filename);
        for (Media media : Library.getItems().values()) {
            if (media instanceof Book){
                output.println(media.getId() + "\t" + media.getClass().getSimpleName() + "\t" + media.getTitle() + "\t" + ((Book) media).getAuthor() + "\t" + ((Book) media).getPublisher() + "\t" + media.getReleaseYear() + "\t" + media.getGenres() + "\t" + media.getLocation() + "\t" + ((Book) media).getPageCount());
            }
            else if(media instanceof DVD){
                output.println(media.getId() + "\t" + media.getClass().getSimpleName() + "\t" + media.getTitle() + "\t" + ((DVD) media).getDirector() + "\t" + ((DVD) media).getStudio() + "\t" + media.getReleaseYear() + "\t" + media.getGenres() + "\t" + media.getLocation() + "\t" + ((DVD) media).getLanguages() + "\t" + ((DVD) media).getDurationMinutes());
            }
            else if(media instanceof Game){
                output.println(media.getId() + "\t" + media.getClass().getSimpleName() + "\t" + media.getTitle() + "\t" + ((Game) media).getDeveloper() + "\t" + ((Game) media).getPublisher() + "\t" + media.getReleaseYear() + "\t" + media.getGenres() + "\t" + media.getLocation() + "\t" + ((Game) media).getPlatform() + "\t" + ((Game) media).getModes());
            }
        }
        output.close();
    }
}
