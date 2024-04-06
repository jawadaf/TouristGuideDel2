package com.example.touristguidedel2.repository;

import com.example.touristguidedel2.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Repository_DB {

    @Value
            ("${spring.datasource.url}")
    private String url;

    @Value
            ("${spring.datasource.username}")
    private String name;

    @Value
            ("${spring.datasource.password}")
    private String password;


    public List<TouristAttraction> getAll() {
        List<TouristAttraction> touristAttractions = new ArrayList<>();
        String SQL = "SELECT * FROM tg.touristguiden;";

        try {
            Connection connection = DriverManager.getConnection(url, name, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String city = resultSet.getString("city");

                touristAttractions.add(new TouristAttraction(id, name, description, city));

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return touristAttractions;
    }

    public void create(TouristAttraction touristAttraction) {
        try (Connection connection = DriverManager.getConnection(url, name, password)) {
            String SQL = "insert into TouristGuiden(name, description, city) values(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, touristAttraction.getName());
            preparedStatement.setString(2, touristAttraction.getDescription());
            preparedStatement.setString(3, touristAttraction.getCity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(TouristAttraction touristAttraction) {
        String SQL = "UPDATE tg.touristAttraction SET name = ?, description = ?, city = ? WHERE id = ?;";
        try {
            Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, touristAttraction.getName());
            preparedStatement.setString(2, touristAttraction.getDescription());
            preparedStatement.setString(3, touristAttraction.getCity());
            preparedStatement.setInt(4, touristAttraction.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TouristAttraction> delete(int id) {
        List<TouristAttraction> touristAttractions = new ArrayList<>();
        String SQL = "DELETE FROM tg.touristguiden where id=?;";

        try {
            Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return touristAttractions;
    }
}





