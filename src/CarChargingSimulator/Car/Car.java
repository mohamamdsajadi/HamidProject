package CarChargingSimulator.Car;

public class Car {
    private String carId;
    private String carName ;
    private Battery battery;

    public Car(String carId, String carName, Battery battery) {
        this.carId = carId;
        this.carName = carName;
        this.battery = battery;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }
}
