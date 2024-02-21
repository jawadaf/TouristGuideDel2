package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TouristRepository {
    private List<TouristAttraction> data = new ArrayList<>();

    public TouristRepository() {
        data.add(new TouristAttraction("Computer", "Programming", "København", List.of("Java", "JavaScript", "Python")));
        data.add(new TouristAttraction("Tivoli", "Forlystelses park midt i København", "Rådhuspladsen", List.of("Restaurant", "Koncert", "Bar")));
        data.add(new TouristAttraction("ZOO", "Europas bedste zoo", "Zimbabwe", List.of("Animals", "Nature", "Food")));
    }

    public List<TouristAttraction> getAll() {
        return data;
    }

    public TouristAttraction getByName(String name) {
        for (TouristAttraction touristAttraction : data) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public void create(TouristAttraction touristAttraction) {
        data.add(touristAttraction);
    }

    public void save(TouristAttraction touristAttraction) {
        if (touristAttraction != null) {
            data.contains(touristAttraction);
        }
    }

    public void edit(String name, String description, String city, List<String> tagList) {
        for (TouristAttraction touristAttraction : data) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                touristAttraction.setDescription(description);
            }
        }
    }

    public void update(TouristAttraction touristAttraction) {
        for (TouristAttraction attraction : data) {
            if (touristAttraction.getName().equals(attraction.getName())) {
                touristAttraction.setDescription(attraction.getDescription());
            }
        }
    }

    public void delete(TouristAttraction touristAttraction) {
        data.removeIf(attraction -> attraction.getName().equals(touristAttraction.getName()));
    }

    public List<String> getNamebyTag(String name) {
        for (TouristAttraction touristAttraction : data) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction.getTagList();
            }
        }
        return Collections.emptyList();
    }

    public List<String> attractionTagsList(String touristAttractionName){
        for (TouristAttraction touristAttraction : data){
            if (touristAttraction.getName().contains(touristAttractionName)){
                return touristAttraction.getTagList();
            }
        }
        return null;
    }



}
