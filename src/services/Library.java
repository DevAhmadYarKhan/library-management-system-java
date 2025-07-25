package services;

import exceptions.DuplicateIdException;
import exceptions.MediaNotFoundException;
import models.*;

import java.util.*;

public class Library {

    private static final Map<Integer, Media> items = new TreeMap<>();

    public static Map<Integer, Media> getItems(){
        return items;
    }

    public void addMedia(Media media) throws DuplicateIdException {
        if (items.containsKey(media.getId())){
            throw new DuplicateIdException("A media item with this ID already exists!");
        }
        items.put(media.getId(), media);
    }

    public void removeMedia(int id) throws MediaNotFoundException {
        if (items.containsKey(id)){
            items.remove(id);
            return;
        }
        throw new MediaNotFoundException("A media item with this ID does not exist!");
    }

    public Media searchMediaById(int id) throws MediaNotFoundException{
        if (items.containsKey(id)){
            return items.get(id);
        }
        throw new MediaNotFoundException("Media item with this ID does not exist!");
    }

    public List<Media> searchMediaByTitle(String title) throws MediaNotFoundException{
        List<Media> filteredMedia = new ArrayList<>();
        for (Map.Entry<Integer, Media> entry : items.entrySet()){
            if (entry.getValue().getTitle().trim().equalsIgnoreCase(title)){
                filteredMedia.add(entry.getValue());
            }
        }
        if (!filteredMedia.isEmpty()){
            return filteredMedia;
        }
        throw new MediaNotFoundException("Media item with this title does not exist!");
    }

    public List<Media> displayAllItems() throws MediaNotFoundException{
        List<Media> itemsList = new ArrayList<>(items.values());
        if (!itemsList.isEmpty()){
            return itemsList;
        }
        throw new MediaNotFoundException("There is currently no stored media in the system.");
    }
}