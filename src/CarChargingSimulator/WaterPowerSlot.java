package CarChargingSimulator;

import CarChargingSimulator.Sources.EnergySource;
import CarChargingSimulator.Sources.Water;

public class WaterPowerSlot extends Slot{
    public WaterPowerSlot(Water energySource ) {
        super(energySource, 80);
    }
}
