package CarChargingSimulator.Sources;

public class Solar  extends EnergySource{
    @Override
    public double energyHarvesting(double amount1) {
        if (this.getTotalAvailableAmount() - amount1 >= 0) {
            double amount = this.getTotalAvailableAmount() - amount1;
            this.setTotalAvailableAmount(amount);
            return amount1 ;
        }
        else throw  new RuntimeException();
    }
}
