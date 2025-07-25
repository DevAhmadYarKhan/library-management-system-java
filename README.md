LIBRARY MANAGEMENT SYSTEM

A Java-based system for managing books, DVDs, and games in a library with physical location tracking and file persistence.


FEATURES

Add, remove, and search books, DVDs, and games

Track physical locations (branch, section, shelf, floor)

Automatic data persistence - saves to file on exit, loads on startup

Search by ID or title

Input validation and error handling


DATA PERSISTENCE

The system automatically handles file operations:

On startup: Loads all media items from "MyMedia" file

On "Save and exit": Writes all current items back to "MyMedia" file

Data format: Tab-separated values with special handling for collections

File location: Same directory as the application


USAGE

Follow the menu prompts to manage your library:

Add new media item

Remove media item

Search media

Display all items

Save and exit (saves to file)

Exit without saving

The system automatically loads your media from file when starting. Any changes made during your session will only be permanently saved if you choose "Save and exit" before quitting.