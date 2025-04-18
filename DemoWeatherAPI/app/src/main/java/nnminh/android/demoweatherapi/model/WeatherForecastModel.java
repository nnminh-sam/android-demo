package nnminh.android.demoweatherapi.model;

public class WeatherForecastModel {
    private String time;
    private String temperature;
    private String iconUrl;
    private String wind;

    public WeatherForecastModel(String time, String temperature, String iconUrl, String wind) {
        this.time = time;
        this.temperature = temperature;
        this.iconUrl = iconUrl;
        this.wind = wind;
    }

    public String getTime() { return time; }
    public String getTemperature() { return temperature; }
    public String getIconUrl() { return iconUrl; }
    public String getWind() { return wind; }
}
