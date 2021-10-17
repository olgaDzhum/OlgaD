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
  public static final String API_KEY = "v7LRCuG1rIqYj7kclmAGJ7wsllKIUgXq";
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
              //    .addQueryParameter("language",LANGUAGE_RU)
              .addQueryParameter("metric", "true")
              .build();

      System.out.println("Ccылка на прогноз погоды: ");
      System.out.println(httpUrl.toString());
      System.out.println();
      Request request = new Request.Builder()
              .url(httpUrl)
              .build();
      Response response = okHttpClient.newCall(request).execute();
      String responseBody = response.body().string();
      System.out.println(responseBody);
      System.out.println();

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

      System.out.println("On the " + date1 + " in " + city + " is " + weatherText1 + " with the maximum temperature " + temperature1 + "C.");
      System.out.println("On the " + date2 + " in " + city + " is " + weatherText2 + " with the maximum temperature " + temperature2 + "C.");
      System.out.println("On the " + date3 + " in " + city + " is " + weatherText3 + " with the maximum temperature " + temperature3 + "C.");
      System.out.println("On the " + date4 + " in " + city + " is " + weatherText4 + " with the maximum temperature " + temperature4 + "C.");
      System.out.println("On the " + date5 + " in " + city + " is " + weatherText5 + " with the maximum temperature " + temperature5 + "C.");


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
              //       .addQueryParameter("Language",LANGUAGE_RU)
              .addQueryParameter("metric", "true")
              .build();

      System.out.println("Ccылка на прогноз погоды: ");
      System.out.println(httpUrl.toString());
      System.out.println();
      Request request = new Request.Builder()
              .url(httpUrl)
              .build();
      Response response = okHttpClient.newCall(request).execute();
      String responseBody = response.body().string();
      System.out.println(responseBody);
      String weatherText = objectMapper.readTree(responseBody).at("/Headline/Text").asText();
      Integer temperature = objectMapper.readTree(responseBody).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asInt();
      //
      System.out.println(city + " " + weatherText + "with maximum temperature " + temperature + "C degrees.");


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
