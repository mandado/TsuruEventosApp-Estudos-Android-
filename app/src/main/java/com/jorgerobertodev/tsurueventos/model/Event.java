package com.jorgerobertodev.tsurueventos.model;

import com.jorgerobertodev.tsurueventos.util.Api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    private String _id;
    private String title;
    private String description;
    private String image;

    public Event(String _id, String title, String description, String image) {
        this._id = _id;
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Event() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUrl(){
        String splitFolder = getImage().split("-")[1];
        String folder = splitFolder.split("\\.")[0]+"/";
        return Api.uploadFolder(folder + getImage());
    }

    @Override
    public String toString() {
        return "Event{" +
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", imageUrl='" + getImageUrl() + '\'' +
                '}';
    }
}
