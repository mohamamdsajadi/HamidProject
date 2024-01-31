package CarChargingSimulator.Sources;

import Exceptions.EnergyExhaustedException;

public class Electrical extends EnergySource {

    public Electrical( ) {
        super(5, 5000);
    }


    @Override
    public double energyHarvesting(double amount1) throws EnergyExhaustedException {
        if (getTotalAvailableAmount() == 0) throw new EnergyExhaustedException(this.getClass().getSimpleName());
        if (this.getTotalAvailableAmount() - amount1 >= 0) {
            double amount = this.getTotalAvailableAmount() - amount1;
            this.setTotalAvailableAmount(amount);
            return amount1 ;
        }
        else throw  new RuntimeException();
    }
}
