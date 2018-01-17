package com.schibsted.sa.detskjer.model;

import java.util.ArrayList;
import java.util.List;

public class EventsList {

    private ArrayList<Event> eventsList;

    public EventsList(List<Event> list) {
        this.eventsList = (ArrayList<Event>) list;
    }

    public List<Event> getEventsList() {
        return eventsList;
    }
}
