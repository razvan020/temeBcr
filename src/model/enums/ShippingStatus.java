package model.enums;

public enum ShippingStatus {
    REGISTERED("Registered", "Shipment has been registered in the system"),
    AWAITING_PICKUP("Awaiting Pickup", "Cargo is waiting to be picked up"),
    IN_TRANSIT("In Transit", "Cargo is currently in transit"),
    CUSTOMS_INSPECTION("Customs Inspection", "Cargo is undergoing customs inspection"),
    LOADING("Loading", "Cargo is being loaded onto a vessel"),
    UNLOADING("Unloading", "Cargo is being unloaded from a vessel"),
    DELAYED("Delayed", "Shipment is experiencing delays"),
    ARRIVED_AT_PORT("Arrived at Port", "Cargo has arrived at the destination port"),
    DELIVERED("Delivered", "Cargo has been delivered to the final destination"),
    RETURNED("Returned", "Cargo has been returned to sender");

    private final String status;
    private final String description;

    ShippingStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return status;
    }
}