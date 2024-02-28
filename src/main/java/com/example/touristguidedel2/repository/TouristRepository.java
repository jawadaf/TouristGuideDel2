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

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        data.add(touristAttraction);
        return touristAttraction;
    }

    public void save(TouristAttraction touristAttraction) {
        if (touristAttraction != null) {
            data.add(touristAttraction);
        }
    }

   public void edit(String name, String description, String city, List<String> tagList) {
        for (TouristAttraction touristAttraction : data) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                touristAttraction.setDescription(description);
                touristAttraction.setCity(city);
                touristAttraction.setTagList(tagList);
                return;
            }
        }
    }

    public TouristAttraction update(TouristAttraction touristAttraction) {
        for (TouristAttraction attraction : data) {
            if (attraction.getName().equals(touristAttraction.getName())) {
                attraction.setDescription(touristAttraction.getDescription());
                attraction.setCity(touristAttraction.getCity());
                attraction.setTagList(touristAttraction.getTagList());
            }
        }
        return touristAttraction;
    }

    public void delete(TouristAttraction touristAttraction) {
        data.removeIf(attraction -> attraction.getName().equals(touristAttraction.getName()));
    }

    public List<String> getNameByTag() {
        List<String> allTags = new ArrayList<>(List.of("Biograf", "Bar", "Museum", "Tivoli", "Park", "Børnevenlig"));
        return allTags;
    }

    public List<String> getCities() {
        List<String> cityList = new ArrayList<>();
        for (TouristAttraction touristAttraction : data) {
            cityList.add(touristAttraction.getCity());
        }
        return cityList;
    }


}
