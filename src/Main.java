import CarChargingSimulator.ChargingStation;
import CarChargingSimulator.Simulator;
import Weather.RainyWeather;
import Weather.SunnyWeather;
import Weather.WindyWeather;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Simulator simulator = new Simulator() ;
//        simulator.setWeatherState(new RainyWeather());
//        simulator.startSimulation();
        LocalDateTime time = LocalDateTime.now();
        Thread.sleep(2000);
        LocalDateTime time1 = LocalDateTime.now();
        System.out.println(time.compareTo(time1));
    }
}