package CarChargingSimulator;

public abstract class EnergySource {

    private  int minutesToFull50Unit ; // the amount of time to charge 50 unit of a battery ( no matter type A or type B )

    private double TotalAvailableAmount; // total available amount of this resource

    public abstract double energyHarvesting();
     public   void energyGenerating(double amount){
         this.TotalAvailableAmount += amount;
     }




}
