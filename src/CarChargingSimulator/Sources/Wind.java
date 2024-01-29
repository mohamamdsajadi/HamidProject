package CarChargingSimulator.Sources;

public class Wind extends EnergySource{
    public Wind() {
        super(15, 3000);
    }

    @Override
    public double energyHarvesting(double amount1) {
        if (getTotalAvailableAmount() == 0) throw new RuntimeException();
        if (this.getTotalAvailableAmount() - amount1 >= 0) {
            double amount = this.getTotalAvailableAmount() - amount1;
            this.setTotalAvailableAmount(amount);
            return amount1 ;
        }
        else throw  new RuntimeException();
    }
}
