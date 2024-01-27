package CarChargingSimulator.Car;

public class ElectricityBatteryTypeB implements Battery {
    private final double capacity=150;

    public double getRemainingCharge() {
        return remainingCharge;
    }

    public void setRemainingCharge(double remainingCharge) {
        this.remainingCharge = remainingCharge;
    }

    public ElectricityBatteryTypeB(double remainingCharge) {
        this.remainingCharge = remainingCharge;
    }

    private double remainingCharge ;
    @Override
    public double getCapacity() {
        return capacity-30;
    }

    @Override
    public void charge(double amount) {

        remainingCharge +=amount;
    }

    @Override
    public double getRemaining() {
        return remainingCharge;
    }
}
