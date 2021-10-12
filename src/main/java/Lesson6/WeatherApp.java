package Lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherApp {

  /* http://dataservice.accuweather.com/forecasts/v1/daily/5day/ */

  public static final String PROTOCOL = "http";
  public static final String BASE_HOST = "dataservice.accuweather.com";
  public static final String FORECASTS = "forecasts";
  public static final String VERSION = "v1";
  public static final String DAILY = "daily";
  public static final String PERIOD = "5day";
  public static final String API_KEY = "lm7ZgwRvuJKFAkEAHBKyThpowprk3PyK";
  public static final String CITY_CODE_MOSCOW = "294021";

  public static HttpUrl createURL() {
    HttpUrl httpUrl = new HttpUrl.Builder()
            .scheme(PROTOCOL)
            .host(BASE_HOST)
            .addPathSegment(FORECASTS)
            .addPathSegment(VERSION)
            .addPathSegment(DAILY)
            .addPathSegment(PERIOD)
            .addPathSegment(CITY_CODE_MOSCOW)
            .addQueryParameter("apikey", API_KEY)
            .build();
    System.out.println("Ccылка на прогноз погоды: ");
    System.out.println(httpUrl.toString());
    System.out.println();
    return httpUrl;
  }

  public static void main(String[] args) throws IOException {
    OkHttpClient okHttpClient = new OkHttpClient();
    Request request = new Request.Builder()
            .url(createURL())
            .build();
    Response response = okHttpClient.newCall(request).execute();
    String responseBody = response.body().string();
    System.out.println(responseBody);

  }

}
