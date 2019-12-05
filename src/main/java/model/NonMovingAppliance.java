package model;

public enum NonMovingAppliance implements GettingPowerable {
    REFRIGERATOR("Refrigerator", 400, true, 60, 70, 220),
    BOILER("Boiler", 600, true, 45, 45, 110),
    OVEN("Oven", 0, false, 50, 40, 60),
    WASHING_MACHINE("Washing machine", 2000, true, 60, 40, 80);

    private final String name;
    private final int consumptionPower;
    private final boolean on;
    private final int width;
    private final int longitude;
    private final int height;

    NonMovingAppliance(String name, int consumptionPower, boolean on, int width, int longitude, int height) {
        this.name = name;
        this.consumptionPower = consumptionPower;
        this.on = on;
        this.width = width;
        this.longitude = longitude;
        this.height = height;
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

    public int getWidth() {
        return width;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return this.name + " uses " + this.consumptionPower + "W." +
                ((this.on) ? " Appliance is turned on." : " Appliance is turned off.") +
                " Volume of this appliance is: " + (this.width * this.longitude * this.height) + "cm2";
    }

}
