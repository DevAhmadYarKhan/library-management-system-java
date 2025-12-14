# Java Library Management System

A robust and feature-rich command-line Library Management System built with core Java. This application allows librarians to manage a diverse media collection, including Books, DVDs, and Games, with persistent storage to a local file.

## ⚠️ Project Context

This project was developed during my first year as a Computer Science undergraduate.
It demonstrates foundational Java concepts such as object-oriented programming, collections, and basic persistence.

Some architectural decisions (including a CLI-based interface and file-based persistence) were chosen for simplicity at the time and introduce limitations in extensibility and separation of concerns.
As such, this project should be viewed as an early learning exercise rather than a representation of my current skill level.


## Features

- **Media Management:** Full CRUD (Create, Read, Update, Delete) operations for three media types:
    - **Books:** Store author, publisher, page count, and more.
    - **DVDs:** Store director, studio, languages, duration, and more.
    - **Games:** Store developer, platform, game modes, and more.
- **Advanced Search:** Search the library by unique ID or by title.
- **Persistent Storage:** Automatically saves the entire library to a text file (`MyMedia`) upon exit. Reloads data automatically on startup if the file exists.
- **Input Validation & Error Handling:** Comprehensive validation for all user inputs with clear error messages. Custom exceptions for duplicate IDs and missing media.
- **Detailed Media Information:** Each item stores a rich set of details, including genres and a precise physical location (branch, section, shelf, floor).
- **Object-Oriented Design:** Clean separation of concerns with dedicated packages for models, services, and exceptions.

## Technologies Used

- **Java SE:** Core language features including Collections Framework, File I/O, and Object-Oriented Programming principles.
- **Custom Exceptions:** For elegant and specific error handling.
- **Java.util Collections:** Heavy use of `Map<Integer, Media>`, `Set<String>`, `List<Media>`, etc., for efficient data management.

## Installation & Compilation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/DevAhmadYarKhan/library-management-system-java.git
    cd library-management-system-java
    ```

2.  **Compile the Java files:**
    Navigate to the directory containing the `CLI.java` file and run:
    ```bash
    javac -d . CLI.java
    ```
    This will compile all `.java` files in the project and place the `.class` files in the correct package structure.

3.  **Run the application:**
    ```bash
    java CLI
    ```

## Usage

Upon starting the program, it will attempt to load existing data from the `MyMedia` file. If none is found, it will initialize an empty library.

You are presented with a main menu:

1. Add new media item
2. Remove media item
3. Search media
4. Display all items
5. Save and exit
6. Exit without saving


### Adding an Item
Select option `1` and choose the media type (Book, DVD, Game). The program will guide you through entering all required details, with validation for each field.

### Removing an Item
Select option `2` and enter the ID of the item you wish to remove. You are asked to confirm the deletion.

### Searching
Select option `3` to search by `ID` (returns one item) or by `Title` (returns all matching items).

### Viewing All Items
Select option `4` to print a formatted list of every item in the library to the console.

### Exiting
- Option `5`: Saves the current state of the library to the `MyMedia` file and exits.
- Option `6`: Exits the program without saving any changes made during the session.

## Data Persistence

The library's state is saved to a plain text file named `MyMedia` (with no file extension). The `MediaIO` class is responsible for the custom serialization and deserialization of the complex object graph into a tab-separated values format. This ensures your library persists between sessions.
