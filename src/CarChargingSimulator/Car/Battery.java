package CarChargingSimulator.Car;

public interface Battery {
    double getCapacity();
    void charge(double amount);

    double getRemaining();
}
