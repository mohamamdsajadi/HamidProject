package CarChargingSimulator;

import CarChargingSimulator.Car.Car;

import java.sql.SQLOutput;

public class  Location {

    private ChargingStation chargingStation;
    private String name;

    private Slot slot;


   volatile private Car car;

    public Location(String name, Slot slot, ChargingStation chargingStation) {
        this.name = name;
        this.slot = slot;
        this.chargingStation = chargingStation;
    }

    public boolean isOccupied() {
        return this.car != null;
    }

    public synchronized void charge() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println();
//        System.out.println("*******************************************************");
        Thread.sleep(1000);
            System.out.println("remaining amount in slot for < " + this.getName() + " > in  "+this.chargingStation.getName()+" is " + slot.getCurrentAmount());
        Thread.sleep(1000);
//        System.out.println("*******************************************************");
        System.out.println();
        Thread.sleep(1000);
        System.out.println();
        System.out.println();
        Thread.sleep(2000);
//        System.out.println("----------------------------------------------------------------");
        Thread.sleep(1000);
        System.out.println("Car :" + car + "\n" + "with Battery status : " + car.getBattery());
        Thread.sleep(1000);
//        System.out.println("----------------------------------------------------------------");
        Thread.sleep(1000);
        System.out.println();
        Thread.sleep(2000);

        System.out.println(" the car " + car +" in "+ getName() +" in  "+ chargingStation.getName()+" is charging ... ");
        chargingStation.showProcessBar();
        double carBatteryRemaining = car.getBattery().getRemaining();
        double carBatteryCapacity = car.getBattery().getCapacity();
        if (carBatteryCapacity - carBatteryRemaining > 0) {
            Thread.sleep(1000);
            try {
                car.getBattery().charge(this.slot.harvest(carBatteryCapacity - carBatteryRemaining));
                Thread.sleep(1000);
            } catch (Exception e) {
        Thread.sleep(2000);
                reFillSlot();
        Thread.sleep(2000);
            } finally {
                Thread.sleep(2000);
                System.out.println();
                System.out.println("##########################################################");
                Thread.sleep(1000);
                System.out.println(" in  :{ "+chargingStation.getName()+" }  the  :"+ car.getCarName() +" ----> battery status after this charge pump : " + car.getBattery());
                Thread.sleep(1000);
                System.out.println("remaining amount in slot " + slot.getCurrentAmount());
                Thread.sleep(1000);
                System.out.println("##########################################################");
                System.out.println();
                Thread.sleep(2000);
                charge();
            }

        } else {
            System.out.println("the  "+ car.getCarName()+"  is gone ");
            detach();
        }


    }

    private void reFillSlot() {
        System.out.println();
        System.out.println(" -------= IN  refill function =---------");
        System.out.println();
        System.out.println("the Charge Slot in  "+this.getName()+" is Empty  .... now we are refilling it");
        this.slot.chargeSlot();
        System.out.println("refilled the current amount slot in  "+ this.getName() +" : " + slot.getCurrentAmount() +"\n----------= END OF REFILL =-------------\n");
    }

    private void detach() {
        this.car = null;
    }

    private void chargeSlot() {
        this.slot.getEnergySource().energyHarvesting(this.slot.getCapacity());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Car getCar() {
        return car;
    }

    public synchronized void setCar(Car car) {
        this.car = car;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
