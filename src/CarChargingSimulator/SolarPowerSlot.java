package CarChargingSimulator;

import CarChargingSimulator.Sources.Electrical;
import CarChargingSimulator.Sources.Solar;

public class SolarPowerSlot extends Slot{
    public SolarPowerSlot() {
        super(new Solar(), 100);
    }
}
