package CarChargingSimulator;

import CarChargingSimulator.Sources.EnergySource;
import CarChargingSimulator.Sources.Wind;

public class WindPowerSlot extends Slot{

    public WindPowerSlot(Wind energySource) {
        super(energySource, 80);

    }
}
