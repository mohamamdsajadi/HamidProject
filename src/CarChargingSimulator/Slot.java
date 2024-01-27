package CarChargingSimulator;

import CarChargingSimulator.Sources.EnergySource;

public class Slot {
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
        if (amount<=currentAmount){
            currentAmount -= amount;
            return amount;
        }
        else throw  new RuntimeException();
    }
    public void  chargeSlot(){
        this.currentAmount += this.getEnergySource().energyHarvesting(this.getCapacity());

    }
}
