package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TouristRepository {



    private final List<TouristAttraction> touristAttractions = new ArrayList<>();


    public List<TouristAttraction> getAll() {
        return touristAttractions;
    }

    public TouristAttraction getByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equals(name)) {
                return touristAttraction;
            }
        }
        return null;
    }



    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
        return touristAttraction;
    }


    public TouristAttraction update(TouristAttraction touristAttraction) {
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equals(touristAttraction.getName())) {
                attraction.setDescription(touristAttraction.getDescription());
                attraction.setCity(touristAttraction.getCity());
                attraction.setTagList(touristAttraction.getTagList());
            }

        }
        return touristAttraction;
    }


    public void delete(TouristAttraction touristAttraction) {
        touristAttractions.removeIf(attraction -> touristAttraction.getName().equals(touristAttraction.getName()));
    }

    public List<String> getNameByTag() {
        List<String> allTags = new ArrayList<>(List.of("Java", "JavaScript", "Python", "Restaurant", "Koncert", "Bar", "Animals", "Nature", "Food"));
        return allTags;
    }




    public List<String> getCities() {
        List<String> cityList = new ArrayList<>();
        for (TouristAttraction touristAttraction : touristAttractions) {
            cityList.add(touristAttraction.getCity());
        }
        return cityList;
    }


}
