package CarChargingSimulator;

import CarChargingSimulator.Sources.EnergySource;

public abstract class Slot {
    private EnergySource energySource ;
    private final double capacity;
    private double currentAmount ;

    public EnergySource getEnergySource() {
        return energySource;
    }

    public void setEnergySource(EnergySource energySource) {
        this.energySource = energySource;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Slot(EnergySource energySource, double capacity) {
        this.energySource = energySource;
        this.capacity = capacity;
        this.currentAmount = capacity;
    }

    public double harvest(double amount){
        if (currentAmount == 0 ) throw  new RuntimeException();

        if (amount<=currentAmount){
            currentAmount -= amount;
            return amount;
        }

        else {
            double amount1 = currentAmount;
            currentAmount = 0 ;
            return amount1;

        }
    }
    public void  chargeSlot()throws RuntimeException{
        if (currentAmount == capacity) return;
        try {

        if (currentAmount == 0 ) {
            this.currentAmount += this.getEnergySource().energyHarvesting(this.getCapacity());
            chargeSlot();
        }
        if (currentAmount!=0  && currentAmount<capacity){
            this.currentAmount += this.getEnergySource().energyHarvesting(capacity-currentAmount);
            chargeSlot();
        }

        }catch (Exception e ){
            System.out.println("the source is over ");
            throw  new RuntimeException();
        }
    }
}
