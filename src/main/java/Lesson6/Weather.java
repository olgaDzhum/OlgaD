package Lesson6;

public class Weather {
    private String date;
    private String cityName;
    private String weatherText;
    private Integer temperature;

    public Weather(String date, String cityName, String weatherText, Integer temperature) {
        this.date = date;
        this.cityName = cityName;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    // System.out.println("On the " + date1 + " in " + city + " is " + weatherText1 + " with the maximum temperature " + temperature1 + "C.");

    @Override
    public String toString() {
        return "On the date of " +
                " " + date + ' ' +
                " in " + cityName + ' ' +
                " is " + weatherText + ' ' +
                " with the maximum temperature " + temperature;
    }
}
