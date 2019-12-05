package model;

public enum MovingAppliance implements GettingPowerable {
    KETTLE("Kettle", 800, true, false),
    IRON("Iron", 0, false, false),
    HAIR_DRYER("Hair dryer", 1500, true, false),
    VACUUM_CLEANER("Vacuum cleaner", 0, false, true);

    private final String name;
    private final int consumptionPower;
    private final boolean on;
    private final boolean hasBattery;

    MovingAppliance(String name, int consumptionPower, boolean on, boolean hasBattery) {
        this.name = name;
        this.consumptionPower = consumptionPower;
        this.on = on;
        this.hasBattery = hasBattery;
    }

    public String getName() {
        return name;
    }


    public int getConsumptionPower() {
        return consumptionPower;
    }

    public boolean isOn() {
        return on;
    }

    public boolean isHasBattery() {
        return hasBattery;
    }



    @Override
    public String toString() {
        return this.name + " uses " + this.consumptionPower + "W." +
                ((this.on) ? " Appliance is turned on." : " Appliance is turned off.") +
                ((this.hasBattery) ? " This appliance has a battery." : " This appliance works via the network.");
    }
}
