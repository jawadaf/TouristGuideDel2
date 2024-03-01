package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {

    TouristRepository touristRepository = new TouristRepository();
    TouristAttraction touristAttraction = new TouristAttraction("Jawad", "Ali", "København", List.of("University", "Programming"));

    @Test
    void getAll() {
        //Arrange
        List<TouristAttraction> actualList = touristRepository.getAll();

        //Act
        actualList.equals(touristRepository.getAll());

        //Assert
        int expected = 3;
        assertEquals(expected, actualList.size());

    }


    @Test
    void getByName() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void addAttraction() {
        //Arrange
        touristRepository.addAttraction(touristAttraction);

        //Act
        List<TouristAttraction> dataList = touristRepository.getAll();

        //Assert
        int expected = 4;
        assertEquals(expected, dataList.size());
    }

   /* @Test
    void save() {
        //Arrange

        //Act

        //Assert
    }

    */

    /*@Test
    void edit() {
        //Arrange


        //Act

        //Assert
    }

     */

    @Test
    void update() {
        //Arrange
        touristRepository.update(touristAttraction);

        //Act


        //Assert
    }

    @Test
    void delete() {
        //Arrange


        //Act


        //Assert
    }



    @Test
    void getNameByTag() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void getCities() {
        //Arrange

        //Act

        //Assert
    }
}