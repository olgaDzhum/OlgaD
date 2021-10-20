package Lesson6;

import java.sql.*;

public class DataBaseRepository {
    private static final String DB_URL = "jdbc:sqlite:weather.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String insertWeatherRequest = "insert into weather (date, city_name, weather_text, temperature) values  (?, ?, ?, ?)";
    String getSavedInfo = "select * from weather";

    public void saveWeather(Weather weather) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertWeatherRequest);
            preparedStatement.setString(1, weather.getDate());
            preparedStatement.setString(2, weather.getCityName());
            preparedStatement.setString(3, weather.getWeatherText());
            preparedStatement.setInt(4, weather.getTemperature());
            preparedStatement.execute();
            connection.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

    }


    public void getSavedWeather() {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getSavedInfo);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("date") + ", ");
                System.out.print(resultSet.getString("city_name") + ", ");
                System.out.print(resultSet.getString("weather_text") + ", ");
                System.out.print(resultSet.getInt("temperature"));
                System.out.println();

            }
            connection.close();
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

