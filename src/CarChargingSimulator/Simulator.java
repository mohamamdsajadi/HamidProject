package CarChargingSimulator;

import CarChargingSimulator.Car.Car;
import CarChargingSimulator.Car.ElectricalBatteryTypeA;
import CarChargingSimulator.Car.ElectricalBatteryTypeB;
import Weather.WeatherState;

import java.util.List;

public class Simulator {
    private List<ChargingStation> stations ;
    private WeatherState weatherState;

    public Simulator() {
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

    public void setWeatherState(WeatherState weatherState) throws InterruptedException {
        this.weatherState = weatherState;
        weatherState.getWeatherStatus();
    }
    public   void startSimulation() throws InterruptedException {
        ChargingStation chargingStation  = new ChargingStation("StationA" ,weatherState);
        Car carA = new Car("123", "Car A", new ElectricalBatteryTypeA(0));
        Car carB = new Car("456", "Car B", new ElectricalBatteryTypeB(0));
        Car carC = new Car("789", "Car C", new ElectricalBatteryTypeA(0));
        Car carD = new Car("101", "Car D", new ElectricalBatteryTypeA(0));
        Car carE = new Car("112", "Car E", new ElectricalBatteryTypeB(0));
        Car carF = new Car("131", "Car F", new ElectricalBatteryTypeA(0));
        Car carG = new Car("415", "Car G", new ElectricalBatteryTypeB(0));
        Car carH = new Car("161", "Car H", new ElectricalBatteryTypeB(0));
        Car carI = new Car("718", "Car I", new ElectricalBatteryTypeA(0));
        Location location= new Location("Location 1" ,new WaterPowerSlot() , chargingStation);
        Location location2= new Location("Location 2" ,new SolarPowerSlot() , chargingStation);
        Location location3= new Location("Location 3" ,new WindPowerSlot() , chargingStation);
        chargingStation.addCar(carA);
        chargingStation.addCar(carB);
        chargingStation.addCar(carC);
        chargingStation.addCar(carD);
        chargingStation.addCar(carE);
        chargingStation.addCar(carF);
        chargingStation.addCar(carG);
        chargingStation.addCar(carH);
        chargingStation.addCar(carI);
        chargingStation.addLocation(location);
        chargingStation.addLocation(location2);
        chargingStation.addLocation(location3);
        chargingStation.startWorking();

    }
}
