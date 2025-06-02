package model.enums;

public enum PortType {
    CONTAINER("Container Port", "Specialized in handling container ships"),
    BULK_CARGO("Bulk Cargo Port", "Handles dry bulk cargo like grain, coal, and ore"),
    INLAND("Inland Port", "Located inland with connections to seaports via rail or road"),
    DRY("Dry Port", "Inland intermodal terminal directly connected to seaport"),
    SMART("Smart Port", "Utilizes digital technology and automation for operations");

    private final String name;
    private final String description;

    PortType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}
