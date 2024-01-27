package CarChargingSimulator;

import Weather.WeatherState;

import java.util.List;

public class Simulator {
    private List<ChargingStation> stations ;
    private WeatherState weatherState;

    public Simulator(List<ChargingStation> stations) {
        this.stations = stations;
    }

    public List<ChargingStation> getStations() {
        return stations;
    }

    public void setStations(List<ChargingStation> stations) {
        this.stations = stations;
    }

    public WeatherState getWeatherState() {
        return weatherState;
    }

    public void setWeatherState(WeatherState weatherState) {
        this.weatherState = weatherState;
        weatherState.getWeatherStatus();
    }
}
