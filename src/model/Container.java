package model;

import model.enums.ContainerType;
import model.enums.ShippingStatus;
import model.interfaces.Trackable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Container implements Trackable {
    private final String containerId;
    private final ContainerType type;
    private final double maxWeightCapacity;
    private final double length;
    private final double width;
    private final double height;
    private double currentWeight;
    private List<Cargo> cargoList;
    private ShippingStatus currentStatus;
    private String currentLocation;
    private LocalDateTime lastUpdated;
    private boolean isSealed;

    public Container(ContainerType type, double maxWeightCapacity, double length, double width, double height) {
        this.containerId = "CONT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.type = type;
        this.maxWeightCapacity = maxWeightCapacity;
        this.length = length;
        this.width = width;
        this.height = height;
        this.currentWeight = 0.0;
        this.cargoList = new ArrayList<>();
        this.currentStatus = ShippingStatus.REGISTERED;
        this.currentLocation = "Storage Facility";
        this.lastUpdated = LocalDateTime.now();
        this.isSealed = false;
    }

    public boolean addCargo(Cargo cargo) {
        if (isSealed) {
            return false;
        }

        if (currentWeight + cargo.getWeight() <= maxWeightCapacity) {
            cargoList.add(cargo);
            currentWeight += cargo.getWeight();
            lastUpdated = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public boolean removeCargo(Cargo cargo) {
        if (isSealed) {
            return false;
        }

        if (cargoList.remove(cargo)) {
            currentWeight -= cargo.getWeight();
            lastUpdated = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public void seal() {
        this.isSealed = true;
        lastUpdated = LocalDateTime.now();
    }

    public void unseal() {
        this.isSealed = false;
        lastUpdated = LocalDateTime.now();
    }

    public boolean isSealed() {
        return isSealed;
    }

    public double getAvailableCapacity() {
        return maxWeightCapacity - currentWeight;
    }

    public double getVolume() {
        return length * width * height;
    }

    public List<Cargo> getCargoList() {
        return new ArrayList<>(cargoList);
    }

    public ContainerType getType() {
        return type;
    }

    public double getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String getTrackingId() {
        return containerId;
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
        return "Container{" +
                "id='" + containerId + '\'' +
                ", type=" + type +
                ", status=" + currentStatus +
                ", location='" + currentLocation + '\'' +
                ", cargo count=" + cargoList.size() +
                ", weight=" + currentWeight + "/" + maxWeightCapacity + " tonnes" +
                ", sealed=" + isSealed +
                '}';
    }
}
