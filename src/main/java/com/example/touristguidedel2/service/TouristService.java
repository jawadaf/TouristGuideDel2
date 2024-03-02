package com.example.touristguidedel2.service;

import com.example.touristguidedel2.model.TouristAttraction;
import com.example.touristguidedel2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAll() {
        return touristRepository.getAll();
    }

    public TouristAttraction getByName(String name) {
        return touristRepository.getByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        touristRepository.addAttraction(touristAttraction);
        return touristAttraction;
    }

    public void save(TouristAttraction touristAttraction) {
        touristRepository.save(touristAttraction);
    }

    public TouristAttraction edit(String name, String description, String city, List<String> tagList) {
        touristRepository.edit(name, description, city, tagList);
        return touristRepository.getByName(name);
    }

    public void update(TouristAttraction touristAttraction) {
        touristRepository.update(touristAttraction);
    }

    public void delete(String name) {
        TouristAttraction touristAttraction = touristRepository.getByName(name);
        if (touristAttraction != null) {
            touristRepository.delete(touristAttraction);
        }
    }

    public List<String> getNameByTag() {
        return touristRepository.getNameByTag();
    }

    public List<String> getCities() {
        return touristRepository.getCities();
    }


}


