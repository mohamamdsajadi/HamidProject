package CarChargingSimulator;

import CarChargingSimulator.Car.Car;

public class Location {

    private String name;

    private  Slot slot ;



    private Car car;

    public Location(String name, Car car  , Slot slot) {
        this.name = name;
        this.car = car;
        this.slot = slot;
    }

    public boolean isOccupied(){
        return  this.car==null;
    }

    public void charge(Car car){
        double carBatteryRemaining = car.getBattery().getRemaining();
        double  carBatteryCapacity = car.getBattery().getCapacity();
        if (  carBatteryCapacity - carBatteryRemaining <= this.slot.getCurrentAmount())
            car.getBattery().charge(carBatteryCapacity-carBatteryRemaining);
        else {
            chargeSlot();
            charge(car);
        }


    }

    private void chargeSlot() {
        this.slot.getEnergySource()
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
