package Lesson6;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherApp implements WeatherModel {


  public static final String PROTOCOL = "http";
  public static final String BASE_HOST = "dataservice.accuweather.com";
  public static final String FORECASTS = "forecasts";
  public static final String VERSION = "v1";
  public static final String DAILY = "daily";
  public static final String FIVE_DAYS = "5day";
  public static final String ONE_DAY = "1day";
  public static final String API_KEY = "lm7ZgwRvuJKFAkEAHBKyThpowprk3PyK";
  public static final String CITY_CODE_MOSCOW = "294021";
  public static final String LOCATIONS = "locations";
  public static final String CITIES = "cities";
  public static final String AUTOCOMPLETE = "autocomplete";
  public static final String LANGUAGE_RU = "ru";

  OkHttpClient okHttpClient = new OkHttpClient();
  ObjectMapper objectMapper = new ObjectMapper();


  /* http://dataservice.accuweather.com/forecasts/v1/daily/5day/ */
  public void getWeather(String city, Period period) throws IOException {
    if (period == Period.FIVE_DAYS) {
      HttpUrl httpUrl = new HttpUrl.Builder()
              .scheme(PROTOCOL)
              .host(BASE_HOST)
              .addPathSegment(FORECASTS)
              .addPathSegment(VERSION)
              .addPathSegment(DAILY)
              .addPathSegment(FIVE_DAYS)
              .addPathSegment(getCityCode(city))
              .addQueryParameter("apikey", API_KEY)
              .addQueryParameter("metric", "true")
              .build();

      // System.out.println("Ccылка на прогноз погоды: ");
      //System.out.println(httpUrl.toString());
      //System.out.println();
      Request request = new Request.Builder()
              .url(httpUrl)
              .build();
      Response response = okHttpClient.newCall(request).execute();
      String responseBody = response.body().string();
      // System.out.println(responseBody);
      // System.out.println();

      String date1 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(0).at("/Date").asText();
      String date2 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(1).at("/Date").asText();
      String date3 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(2).at("/Date").asText();
      String date4 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(3).at("/Date").asText();
      String date5 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(4).at("/Date").asText();
      String weatherText1 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(0).at("/Day/IconPhrase").asText();
      String weatherText2 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(1).at("/Day/IconPhrase").asText();
      String weatherText3 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(2).at("/Day/IconPhrase").asText();
      String weatherText4 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(3).at("/Day/IconPhrase").asText();
      String weatherText5 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(4).at("/Day/IconPhrase").asText();
      Integer temperature1 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asInt();
      Integer temperature2 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(1).at("/Temperature/Maximum/Value").asInt();
      Integer temperature3 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(2).at("/Temperature/Maximum/Value").asInt();
      Integer temperature4 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(3).at("/Temperature/Maximum/Value").asInt();
      Integer temperature5 = objectMapper.readTree(responseBody).at("/DailyForecasts").get(4).at("/Temperature/Maximum/Value").asInt();

      Weather weather1 = new Weather(date1, city, weatherText1, temperature1);
      Weather weather2 = new Weather(date2, city, weatherText2, temperature2);
      Weather weather3 = new Weather(date3, city, weatherText3, temperature3);
      Weather weather4 = new Weather(date4, city, weatherText4, temperature4);
      Weather weather5 = new Weather(date5, city, weatherText5, temperature5);

      System.out.println(weather1.toString());
      System.out.println(weather2.toString());
      System.out.println(weather3.toString());
      System.out.println(weather4.toString());
      System.out.println(weather5.toString());
      System.out.println("===================================================");

      DataBaseRepository dataBaseRepository = new DataBaseRepository();
      dataBaseRepository.saveWeather(weather1);
      dataBaseRepository.saveWeather(weather2);
      dataBaseRepository.saveWeather(weather3);
      dataBaseRepository.saveWeather(weather4);
      dataBaseRepository.saveWeather(weather5);

    }
    if (period == Period.ONE_DAY) {

      HttpUrl httpUrl = new HttpUrl.Builder()
              .scheme(PROTOCOL)
              .host(BASE_HOST)
              .addPathSegment(FORECASTS)
              .addPathSegment(VERSION)
              .addPathSegment(DAILY)
              .addPathSegment(ONE_DAY)
              .addPathSegment(getCityCode(city))
              .addQueryParameter("apikey", API_KEY)
              .addQueryParameter("metric", "true")
              .build();

      // System.out.println("Ccылка на прогноз погоды: ");
      // System.out.println(httpUrl.toString());
      // System.out.println();
      Request request = new Request.Builder()
              .url(httpUrl)
              .build();
      Response response = okHttpClient.newCall(request).execute();
      String responseBody = response.body().string();
      // System.out.println(responseBody);
      String date = objectMapper.readTree(responseBody).at("/Headline/EffectiveDate").asText();
      String weatherText = objectMapper.readTree(responseBody).at("/Headline/Text").asText();
      Integer temperature = objectMapper.readTree(responseBody).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asInt();

      Weather weather = new Weather(date, city, weatherText, temperature);
      System.out.println(weather.toString());
      System.out.println("===================================================");
      DataBaseRepository dataBaseRepository = new DataBaseRepository();
      dataBaseRepository.saveWeather(weather);

    }

  }


  public String getCityCode(String city) throws IOException {
    //   http://dataservice.accuweather.com/locations/v1/cities/autocomplete

    HttpUrl httpUrl = new HttpUrl.Builder()
            .scheme(PROTOCOL)
            .host(BASE_HOST)
            .addPathSegment(LOCATIONS)
            .addPathSegment(VERSION)
            .addPathSegment(CITIES)
            .addPathSegment(AUTOCOMPLETE)
            .addQueryParameter("apikey", API_KEY)
            //      .addQueryParameter("Language",LANGUAGE_RU)
            .addQueryParameter("q", city)
            .build();


    Request request = new Request.Builder()
            .url(httpUrl)
            .build();

    Response response = okHttpClient.newCall(request).execute();

    String responseBody = response.body().string();


    String cityKey = objectMapper.readTree(responseBody).get(0).at("/Key").asText();
    return cityKey;
  }



}
