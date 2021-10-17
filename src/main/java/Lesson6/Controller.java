package Lesson6;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    WeatherModel weatherModel = new WeatherApp();
    Map<Integer, Period> variantResults = new HashMap<>();

    public Controller() {
        variantResults.put(1, Period.ONE_DAY);
        variantResults.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String days, String city) throws IOException {
        Integer integerDay = Integer.parseInt(days);


        try {

            switch (variantResults.get(integerDay)) {
                case ONE_DAY:
                    weatherModel.getWeather(city, Period.ONE_DAY);
                    break;
                case FIVE_DAYS:
                    weatherModel.getWeather(city, Period.FIVE_DAYS);
            }
        } catch (NullPointerException e) {
            System.out.println("ОШИБКА! Вы ввели некорректные данные, полпробуйте еще раз.");
        }

    }
}
