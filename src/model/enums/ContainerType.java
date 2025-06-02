package model.enums;

public enum ContainerType {
    FCL_STANDARD("Full Container Load - Standard", 6.1),
    FCL_HIGH_CUBE("Full Container Load - High Cube", 12.2),
    FCL_REFRIGERATED("Full Container Load - Refrigerated", 12.2),
    FCL_TANK("Full Container Load - Tank", 6.1),
    FCL_OPEN_TOP("Full Container Load - Open Top", 12.2),
    LCL_STANDARD("Less than Container Load - Standard", 6.1),
    LCL_SPECIAL("Less than Container Load - Special Handling", 6.1);

    private final String description;
    private final double standardSizeInMeters;

    ContainerType(String description, double standardSizeInMeters) {
        this.description = description;
        this.standardSizeInMeters = standardSizeInMeters;
    }

    public String getDescription() {
        return description;
    }

    public double getStandardSizeInMeters() {
        return standardSizeInMeters;
    }

    @Override
    public String toString() {
        return description + " (" + standardSizeInMeters + "m)";
    }
}
