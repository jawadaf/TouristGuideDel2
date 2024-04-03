package com.example.touristguidedel2.model;

import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private String city;
    private List<String> tagList;
    private int id;

    public TouristAttraction(String name, String description, String city, List<String> tagList) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tagList = tagList;
    }

    public TouristAttraction(int id, String name, String description, String city) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }
}
