import Weather.RainyWeather;
import Weather.SunnyWeather;
import Weather.WindyWeather;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SunnyWeather windyWeather = new SunnyWeather();
        windyWeather.shine();
    }
}