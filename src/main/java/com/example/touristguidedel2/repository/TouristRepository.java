package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> data = new ArrayList<>();

    public TouristRepository() {
        data.add(new TouristAttraction("Java", "Programming"));
        data.add(new TouristAttraction("Tivoli", "Forlystelses park midt i København"));
        data.add(new TouristAttraction("Odense zoo", "Europas bedste zoo"));
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

    public void saveName(TouristAttraction touristAttraction) {
        if (touristAttraction != null) {

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


}
