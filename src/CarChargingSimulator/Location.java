package CarChargingSimulator;

import CarChargingSimulator.Car.Car;

public class Location {

    private String name;

    private EnergySource energySource;
    private Car car;

    public Location(String name, EnergySource energySource, Car car) {
        this.name = name;
        this.energySource = energySource;
        this.car = car;
    }

    public boolean isOccupied(){
        return  this.car==null;
    }

    public void Charge(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnergySource getEnergySource() {
        return energySource;
    }

    public void setEnergySource(EnergySource energySource) {
        this.energySource = energySource;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
