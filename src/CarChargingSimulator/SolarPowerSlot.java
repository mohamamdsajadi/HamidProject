package CarChargingSimulator;

import CarChargingSimulator.Sources.Electrical;

public class SolarPowerSlot extends Slot{
    public SolarPowerSlot() {
        super(new Electrical(), 100);
    }
}
