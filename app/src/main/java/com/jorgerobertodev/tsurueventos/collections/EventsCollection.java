package com.jorgerobertodev.tsurueventos.collections;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jorgerobertodev.tsurueventos.model.Event;

import java.util.ArrayList;

/**
 * Created by jorge on 04/04/2015.
 */
public class EventsCollection{
    @JsonProperty("events")
    private ArrayList<Event> events = new ArrayList<Event>();

    public EventsCollection(ArrayList<Event> events) {
        this.events = events;
    }

    public EventsCollection() {
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventsCollection{" +
                "events=" + events.get(0).toString() +
                '}';
    }
}
