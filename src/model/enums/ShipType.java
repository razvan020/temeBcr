package model.enums;


public enum ShipType {
    CONTAINER("Container Ship", 10000, 46),
    GENERAL_CARGO("General Cargo Ship", 7000, 33),
    BULK_CARRIER("Bulk Carrier", 8000, 28),
    REEFER("Refrigerated Ship", 6000, 37),
    RORO("Roll-on/Roll-off Vessel", 6000, 41),
    TANKER("Tanker Ship", 12000, 30);

    private final String name;
    private final int averageCapacityTons;
    private final int averageSpeedKmh;

    ShipType(String name, int averageCapacityTons, int averageSpeedKmh) {
        this.name = name;
        this.averageCapacityTons = averageCapacityTons;
        this.averageSpeedKmh = averageSpeedKmh;
    }

    public String getName() {
        return name;
    }

    public int getAverageCapacityTons() {
        return averageCapacityTons;
    }

    public int getAverageSpeedKmh() {
        return averageSpeedKmh;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + averageCapacityTons + " tonnes, Speed: " + averageSpeedKmh + " km/h)";
    }
}
