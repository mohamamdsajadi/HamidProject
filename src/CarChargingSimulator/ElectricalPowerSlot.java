package CarChargingSimulator;

import CarChargingSimulator.Sources.Electrical;

public class ElectricalPowerSlot extends Slot{
    public ElectricalPowerSlot(Electrical electrical) {
        super(electrical, 100);
    }
}
