import exceptions.DuplicateIdException;
import exceptions.MediaNotFoundException;
import models.*;
import services.*;
import java.io.FileNotFoundException;
import java.util.*;

public class CLI {
    public static void main(String[] args) {
        Library library = new Library();
        MediaIO io = new MediaIO();
        Scanner scanner = new Scanner(System.in);
        try{
            io.readMedia("MyMedia");
            System.out.println("Loaded " + Library.getItems().size() + " items from file\n");
        } catch (FileNotFoundException fnfe) {
            System.out.println("No existing media library found. Initializing a new empty library.\n");
        }
        mainLoop:
        while(true){
            System.out.println("1. Add new media item\n2. Remove media item\n3. Search media\n4. Display all items\n5. Save and exit\n6. Exit without saving\n\nEnter your choice[1-6]");
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                while (true) {
                    System.out.println("Select media type:\n1. Book\n2. DVD\n3. Game\n4. Back to main menu\n\nEnter your choice[1-4]");
                    String input1 = scanner.nextLine().trim();
                    if (input1.equals("1")) {
                        String mediaType = "Book";
                        int id;
                        while(true){
                            try {
                                System.out.println("Enter ID: ");
                                id = Integer.parseInt(scanner.nextLine().trim());
                                if (id > 0){
                                    break;
                                }
                                else{
                                    System.err.println("Invalid input! Please provide a positive integer as ID");
                                }
                            } catch (NumberFormatException nfe) {
                                System.err.println("Invalid input! Please provide a positive integer as ID.");
                            }
                        }
                        String title;
                        while(true){
                            System.out.println("Enter title: ");
                            title = scanner.nextLine().trim();
                            if (!title.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.err.println("Please enter a title.");
                            }
                        }
                        String author;
                        while(true){
                            System.out.println("Enter author: ");
                            author = scanner.nextLine().trim();
                            if (!author.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.err.println("Please enter an author.");
                            }
                        }
                        String publisher;
                        while(true){
                            System.out.println("Enter publisher: ");
                            publisher = scanner.nextLine().trim();
                            if (!publisher.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.err.println("Please enter a publisher.");
                            }
                        }
                        int releaseYear;
                        while(true){
                            try{
                                System.out.println("Enter release year: ");
                                releaseYear = Integer.parseInt(scanner.nextLine().trim());
                                if (releaseYear > 0){
                                    break;
                                }
                                else{
                                    System.err.println("Invalid input! Please provide a positive integer as the release year.");
                                }
                            } catch (NumberFormatException nfe) {
                                System.err.println("Invalid input! Please provide a positive integer as the release year.");
                            }
                        }
                        Set<String> genres;
                        while(true){
                            System.out.println("Enter genres (comma-separated): ");
                            String[] genreArray = scanner.nextLine().replace(", ", ",").trim().split(",");
                            if (genreArray[0].isEmpty() && genreArray.length == 1){
                                System.err.println("Please enter a genre(s).");
                            }
                            else{
                                genres = new HashSet<>(Arrays.asList(genreArray));
                                break;
                            }
                        }
                        System.out.println("Enter location details:\n\nEnter branch: ");
                        String branch = scanner.nextLine().trim();
                        System.out.println("Enter section: ");
                        String section = scanner.nextLine().trim();
                        System.out.println("Enter shelf: ");
                        String shelf = scanner.nextLine().trim();
                        System.out.println("Enter floor: ");
                        String floor = scanner.nextLine().trim();
                        Location location = new Location(branch, section, shelf, floor);
                        int pageCount;
                        while(true){
                            try{
                                System.out.println("Enter page-count: ");
                                pageCount = Integer.parseInt(scanner.nextLine().trim());
                                if (pageCount > 0){
                                    break;
                                }
                                else{
                                    System.err.println("Invalid input! Please provide a positive integer as the page-count.");
                                }
                            } catch (NumberFormatException nfe) {
                                System.err.println("Invalid input! Please provide a positive integer as the page-count.");
                            }
                        }
                        try {
                            library.addMedia(new Book(id, mediaType, title, author, publisher, releaseYear, genres, location, pageCount));
                            System.out.println("New media item successfully added!");
                        } catch (DuplicateIdException die) {
                            System.err.println(die.getMessage());
                            break;
                        }
                    } else if (input1.equals("2")) {
                        String mediaType = "DVD";
                        int id;
                        while(true){
                            try {
                                System.out.println("Enter ID: ");
                                id = Integer.parseInt(scanner.nextLine().trim());
                                if (id > 0){
                                    break;
                                }
                                else{
                                    System.err.println("Invalid input! Please provide a positive integer as ID");
                                }
                            } catch (NumberFormatException nfe) {
                                System.err.println("Invalid input! Please provide a positive integer as ID.");
                            }
                        }
                        String title;
                        while(true){
                            System.out.println("Enter title: ");
                            title = scanner.nextLine().trim();
                            if (!title.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.out.println("Please enter a title.");
                            }
                        }
                        String director;
                        while(true){
                            System.out.println("Enter director: ");
                            director = scanner.nextLine().trim();
                            if (!director.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.out.println("Please enter a director.");
                            }
                        }
                        String studio;
                        while(true){
                            System.out.println("Enter studio: ");
                            studio = scanner.nextLine().trim();
                            if (!studio.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.out.println("Please enter a studio.");
                            }
                        }
                        int releaseYear;
                        while(true){
                            try{
                                System.out.println("Enter release year: ");
                                releaseYear = Integer.parseInt(scanner.nextLine().trim());
                                if (releaseYear > 0){
                                    break;
                                }
                                else{
                                    System.err.println("Invalid input! Please provide a positive integer as the release year.");
                                }
                            } catch (NumberFormatException nfe) {
                                System.err.println("Invalid input! Please provide a positive integer as the release year.");
                            }
                        }
                        Set<String> genres;
                        while(true){
                            System.out.println("Enter genres (comma-separated): ");
                            String[] genreArray = scanner.nextLine().replace(", ", ",").trim().split(",");
                            if (genreArray[0].isEmpty() && genreArray.length == 1){
                                System.err.println("Please enter a genre(s).");
                            }
                            else{
                                genres = new HashSet<>(Arrays.asList(genreArray));
                                break;
                            }
                        }
                        System.out.println("Enter location details:\n\nEnter branch: ");
                        String branch = scanner.nextLine().trim();
                        System.out.println("Enter section: ");
                        String section = scanner.nextLine().trim();
                        System.out.println("Enter shelf: ");
                        String shelf = scanner.nextLine().trim();
                        System.out.println("Enter floor: ");
                        String floor = scanner.nextLine().trim();
                        Location location = new Location(branch, section, shelf, floor);
                        Set<String> languages;
                        while(true){
                            System.out.println("Enter languages (comma-separated): ");
                            String[] languageArray = scanner.nextLine().replace(", ", ",").trim().split(",");
                            if (languageArray[0].isEmpty() && languageArray.length == 1){
                                System.err.println("Please enter a language(s).");
                            }
                            else{
                                languages = new HashSet<>(Arrays.asList(languageArray));
                                break;
                            }
                        }
                        int durationMinutes;
                        while(true){
                            try{
                                System.out.println("Enter duration (minutes): ");
                                durationMinutes = Integer.parseInt(scanner.nextLine().trim());
                                if (durationMinutes > 0){
                                    break;
                                }
                                else{
                                    System.err.println("Invalid input! Please provide a positive integer as the duration.");
                                }
                            } catch (NumberFormatException nfe) {
                                System.err.println("Invalid input! Please provide a positive integer as the duration.");
                            }
                        }
                        try {
                            library.addMedia(new DVD(id, mediaType, title, director, studio, releaseYear, genres, location, languages, durationMinutes));
                            System.out.println("New media item successfully added!");
                        } catch (DuplicateIdException die) {
                            System.err.println(die.getMessage());
                            break;
                        }
                    } else if (input1.equals("3")) {
                        String mediaType = "Game";
                        int id;
                        while(true){
                            try {
                                System.out.println("Enter ID: ");
                                id = Integer.parseInt(scanner.nextLine().trim());
                                break;
                            } catch (NumberFormatException nfe) {
                                System.err.println("Error! Please provide a positive integer as ID.");
                            }
                        }
                        String title;
                        while(true){
                            System.out.println("Enter title: ");
                            title = scanner.nextLine().trim();
                            if (!title.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.out.println("Please enter a title.");
                            }
                        }
                        String developer;
                        while(true){
                            System.out.println("Enter developer: ");
                            developer = scanner.nextLine().trim();
                            if (!developer.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.out.println("Please enter a developer.");
                            }
                        }
                        String publisher;
                        while(true){
                            System.out.println("Enter publisher: ");
                            publisher = scanner.nextLine().trim();
                            if (!publisher.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.out.println("Please enter a publisher.");
                            }
                        }
                        int releaseYear;
                        while(true){
                            try{
                                System.out.println("Enter release year: ");
                                releaseYear = Integer.parseInt(scanner.nextLine().trim());
                                if (releaseYear > 0){
                                    break;
                                }
                                else{
                                    System.err.println("Invalid input! Please provide a positive integer as the release year.");
                                }
                            } catch (NumberFormatException nfe) {
                                System.err.println("Invalid input! Please provide a positive integer as the release year.");
                            }
                        }
                        Set<String> genres;
                        while(true){
                            System.out.println("Enter genres (comma-separated): ");
                            String[] genreArray = scanner.nextLine().replace(", ", ",").trim().split(",");
                            if (genreArray[0].isEmpty() && genreArray.length == 1){
                                System.err.println("Please enter a language(s).");
                            }
                            else{
                                genres = new HashSet<>(Arrays.asList(genreArray));
                                break;
                            }
                        }
                        System.out.println("Enter location details:\n\nEnter branch: ");
                        String branch = scanner.nextLine().trim();
                        System.out.println("Enter section: ");
                        String section = scanner.nextLine().trim();
                        System.out.println("Enter shelf: ");
                        String shelf = scanner.nextLine().trim();
                        System.out.println("Enter floor: ");
                        String floor = scanner.nextLine().trim();
                        Location location = new Location(branch, section, shelf, floor);
                        String platform;
                        while(true){
                            System.out.println("Enter platform: ");
                            platform = scanner.nextLine().trim();
                            if (!platform.trim().isEmpty()){
                                break;
                            }
                            else{
                                System.out.println("Please enter a platform.");
                            }
                        }
                        List<String> modes;
                        while(true){
                            System.out.println("Enter modes (comma-separated): ");
                            String[] modesArray = scanner.nextLine().replace(", ", ",").trim().split(",");
                            if (modesArray[0].isEmpty() && modesArray.length == 1){
                                System.err.println("Please enter a mode(s).");
                            }
                            else{
                                modes = new ArrayList<>(Arrays.asList(modesArray));
                                break;
                            }
                        }
                        try {
                            library.addMedia(new Game(id, mediaType, title, developer, publisher, releaseYear, genres, location, platform, modes));
                            System.out.println("New media item successfully added!");
                        } catch (DuplicateIdException die) {
                            System.err.println(die.getMessage());
                            break;
                        }
                    } else if (input1.equals("4")) {
                        break;
                    } else {
                        System.out.println("Invalid input! Please enter a number between 1 and 4 inclusive.");
                    }
                }
            }
            else if(input.equals("2")){
                while(true){
                    int id;
                    System.out.println("Enter item ID or type 'back' to go back: ");
                    String line = scanner.nextLine().trim();
                    if (line.equalsIgnoreCase("back")){
                        break;
                    }
                    else{
                        try{
                            id = Integer.parseInt(line);
                        } catch (NumberFormatException nfe) {
                            System.err.println("Invalid input! Please provide a positive integer as ID.");
                            continue;
                        }
                    }
                    while(true) {
                        try {
                            System.out.println("CONFIRM REMOVAL\n" + library.searchMediaById(id) + "\nAre you sure? (Y/N): ");
                        } catch (MediaNotFoundException nfe) {
                            System.err.println(nfe.getMessage());
                            break;
                        }
                        String input1 = scanner.nextLine().trim();
                        if (input1.equalsIgnoreCase("Y")) {
                            library.removeMedia(id);
                            System.out.println("Item removed successfully!");
                            break;
                        } else if (input1.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            System.err.println("Invalid input! Please enter Y or N.");
                        }
                    }
                }
            }
            else if (input.equals("3")){
                while(true){
                    System.out.println("Search by:\n1. ID\n2. Title\n3. Back to main menu");
                    String input1 = scanner.nextLine().trim();
                    if(input1.equals("1")){
                        while(true){
                            int id;
                            System.out.println("Enter item ID or type 'back' to go back: ");
                            String line = scanner.nextLine().trim();
                            if (line.equalsIgnoreCase("back")){
                                break;
                            }
                            else{
                                try {
                                    id = Integer.parseInt(line);
                                } catch (NumberFormatException nfe) {
                                    System.err.println("Invalid input! Please enter a positive integer.");
                                    continue;
                                }
                                try {
                                    System.out.println(library.searchMediaById(id));
                                } catch (MediaNotFoundException mnfe) {
                                    System.err.println(mnfe.getMessage());
                                }
                            }
                        }
                    }
                    else if (input1.equals("2")){
                        while(true){
                            System.out.println("Enter item title or type 'back' to go back: ");
                            String title = scanner.nextLine().trim();
                            if (title.equalsIgnoreCase("back")){
                                break;
                            }
                            else{
                                try {
                                    for (Media item : library.searchMediaByTitle(title)) {
                                        System.out.println(item);
                                    }
                                }
                                catch (MediaNotFoundException mnfe) {
                                    System.err.println(mnfe.getMessage());
                                }
                            }
                        }
                    }
                    else if(input1.equals("3")){
                        break;
                    }
                    else{
                        System.out.println("Invalid input! Please enter a number between 1 and 3 inclusive.");
                    }
                }
            }
            else if (input.equals("4")){
                try{
                    for(Media item : library.displayAllItems()){
                        System.out.println(item);
                    }
                } catch (MediaNotFoundException mnfe) {
                    System.err.println(mnfe.getMessage());
                }
            }
            else if(input.equals("5")) {
                while(true) {
                    System.out.println("Are you sure you want to save and exit the program? (Y/N): ");
                    String input1 = scanner.nextLine().trim();
                    if (input1.equalsIgnoreCase("Y")) {
                        try {
                            io.writeMedia("MyMedia");
                            break mainLoop;
                        } catch (FileNotFoundException fnfe) {
                            System.err.println(fnfe.getMessage());
                        }
                    } else if (input1.equalsIgnoreCase("N")) {
                        break;
                    } else {
                        System.out.println("Invalid input! Please enter Y or N.");
                    }
                }
            }
            else if(input.equals("6")){
                while(true) {
                    System.out.println("Are you sure you want to exit the program without saving? (Y/N): ");
                    String input1 = scanner.nextLine().trim();
                    if (input1.equalsIgnoreCase("Y")) {
                        break mainLoop;
                    } else if (input1.equalsIgnoreCase("N")) {
                        break;
                    } else {
                        System.out.println("Invalid input! Please enter Y or N.");
                    }
                }
            }
            else{
                System.out.println("Invalid input! Please enter a number between 1 and 6 inclusive.");
            }
        }
    }
}
