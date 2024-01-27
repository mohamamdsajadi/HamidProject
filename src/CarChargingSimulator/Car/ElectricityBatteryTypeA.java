package CarChargingSimulator.Car;

public class ElectricityBatteryTypeA  implements Battery{
    private final double capacity  = 100 ;
    private  double  remainingCharge  ;

    public ElectricityBatteryTypeA(double remainingCharge) {
        this.remainingCharge = remainingCharge;
    }

    @Override
    public double getCapacity() {
        return capacity;
    }

    @Override
    public void charge(double amount) {

        remainingCharge += amount;
    }
}
