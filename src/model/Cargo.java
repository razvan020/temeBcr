package model;

import model.enums.ShippingStatus;
import model.interfaces.Trackable;

import java.time.LocalDateTime;
import java.util.UUID;

public class Cargo implements Trackable {
    private final String cargoId;
    private final String description;
    private final double weight;
    private final double volume;
    private final boolean hazardous;
    private final boolean fragile;
    private final boolean perishable;
    private final LocalDateTime expiryDate;
    private ShippingStatus currentStatus;
    private String currentLocation;
    private LocalDateTime lastUpdated;
    private String sender;
    private String recipient;
    private String destinationAddress;

    public Cargo(String description, double weight, double volume, boolean hazardous, boolean fragile, 
                boolean perishable, LocalDateTime expiryDate, String sender, String recipient, 
                String destinationAddress) {
        this.cargoId = "CARGO-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.description = description;
        this.weight = weight;
        this.volume = volume;
        this.hazardous = hazardous;
        this.fragile = fragile;
        this.perishable = perishable;
        this.expiryDate = expiryDate;
        this.sender = sender;
        this.recipient = recipient;
        this.destinationAddress = destinationAddress;
        this.currentStatus = ShippingStatus.REGISTERED;
        this.currentLocation = "Warehouse";
        this.lastUpdated = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isHazardous() {
        return hazardous;
    }

    public boolean isFragile() {
        return fragile;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        if (!perishable || expiryDate == null) {
            return false;
        }
        return LocalDateTime.now().isAfter(expiryDate);
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setSender(String sender) {
        this.sender = sender;
        this.lastUpdated = LocalDateTime.now();
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
        this.lastUpdated = LocalDateTime.now();
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
        this.lastUpdated = LocalDateTime.now();
    }

    @Override
    public String getTrackingId() {
        return cargoId;
    }

    @Override
    public ShippingStatus getCurrentStatus() {
        return currentStatus;
    }

    @Override
    public void updateStatus(ShippingStatus status) {
        this.currentStatus = status;
        this.lastUpdated = LocalDateTime.now();
    }

    @Override
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
        this.lastUpdated = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Cargo: " + description + " (ID: " + cargoId + ")\n" +
               "Status: " + currentStatus + "\n" +
               "Location: " + currentLocation + "\n" +
               "Weight: " + weight + " tonnes, Volume: " + volume + " cubic meters\n" +
               "From: " + sender + "\n" +
               "To: " + recipient + " at " + destinationAddress + "\n" +
               "Properties: " + 
               (hazardous ? "Hazardous " : "") +
               (fragile ? "Fragile " : "") +
               (perishable ? "Perishable" : "") +
               (perishable && expiryDate != null ? " (Expires: " + expiryDate + ")" : "");
    }
}
