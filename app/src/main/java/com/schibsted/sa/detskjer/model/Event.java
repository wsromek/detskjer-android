package com.schibsted.sa.detskjer.model;

import java.util.List;

public class Event {
    public String name;
    public String description;
    public List<GalleryItem> galleryItems = null;

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
