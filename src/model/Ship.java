package model;

import model.employees.Captain;
import model.enums.ShipType;
import model.enums.ShippingStatus;
import model.interfaces.ContainerManager;
import model.interfaces.Trackable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Ship implements Trackable, ContainerManager {
    private final String shipId;
    private final String name;
    private final ShipType type;
    private final int maxContainerCapacity;
    private final double maxWeightCapacity; // in tonnes
    private Captain captain;
    private Map<String, Container> containerMap;
    private List<Container> containerList;
    private ShippingStatus currentStatus;
    private String currentLocation;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime estimatedArrivalTime;
    private LocalDateTime lastUpdated;
    private double currentWeight;
    private boolean inTransit;

    public Ship(String name, ShipType type, int maxContainerCapacity, double maxWeightCapacity) {
        this.shipId = "SHIP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.name = name;
        this.type = type;
        this.maxContainerCapacity = maxContainerCapacity;
        this.maxWeightCapacity = maxWeightCapacity;
        this.containerMap = new HashMap<>();
        this.containerList = new ArrayList<>();
        this.currentStatus = ShippingStatus.REGISTERED;
        this.currentLocation = "Port";
        this.lastUpdated = LocalDateTime.now();
        this.currentWeight = 0.0;
        this.inTransit = false;
    }

    public String getName() {
        return name;
    }

    public ShipType getType() {
        return type;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
        if (captain != null) {
            captain.assignToShip(this);
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
        this.lastUpdated = LocalDateTime.now();
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
        this.lastUpdated = LocalDateTime.now();
    }

    public LocalDateTime getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(LocalDateTime estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.lastUpdated = LocalDateTime.now();
    }

    public boolean isInTransit() {
        return inTransit;
    }

    public void setInTransit(boolean inTransit) {
        this.inTransit = inTransit;
        if (inTransit) {
            this.currentStatus = ShippingStatus.IN_TRANSIT;
        } else if (this.currentStatus == ShippingStatus.IN_TRANSIT) {
            this.currentStatus = ShippingStatus.ARRIVED_AT_PORT;
        }
        this.lastUpdated = LocalDateTime.now();
    }

    public boolean startVoyage(String destination, LocalDateTime departureTime, LocalDateTime estimatedArrivalTime) {
        if (captain == null) {
            return false;
        }

        this.destination = destination;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.inTransit = true;
        this.currentStatus = ShippingStatus.IN_TRANSIT;
        this.lastUpdated = LocalDateTime.now();

        return true;
    }

    public void completeVoyage(String arrivalLocation) {
        this.currentLocation = arrivalLocation;
        this.inTransit = false;
        this.currentStatus = ShippingStatus.ARRIVED_AT_PORT;
        this.lastUpdated = LocalDateTime.now();

        if (captain != null) {
            captain.completeVoyage();
        }
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public double getAvailableWeightCapacity() {
        return maxWeightCapacity - currentWeight;
    }

    @Override
    public boolean addContainer(Container container) {
        if (containerList.size() >= maxContainerCapacity) {
            return false;
        }

        if (currentWeight + container.getCurrentWeight() > maxWeightCapacity) {
            return false;
        }

        containerList.add(container);
        containerMap.put(container.getTrackingId(), container);
        currentWeight += container.getCurrentWeight();
        lastUpdated = LocalDateTime.now();
        return true;
    }

    @Override
    public boolean removeContainer(Container container) {
        if (containerList.remove(container)) {
            containerMap.remove(container.getTrackingId());
            currentWeight -= container.getCurrentWeight();
            lastUpdated = LocalDateTime.now();
            return true;
        }
        return false;
    }

    @Override
    public boolean removeContainer(String containerId) {
        Container container = containerMap.get(containerId);

        if (container != null) {
            return removeContainer(container);
        }
        return false;
    }

    @Override
    public List<Container> getAllContainers() {
        return new ArrayList<>(containerList);
    }

    @Override
    public int getContainerCount() {
        return containerList.size();
    }

    @Override
    public int getMaxCapacity() {
        return maxContainerCapacity;
    }

    @Override
    public boolean hasAvailableCapacity() {
        return containerList.size() < maxContainerCapacity;
    }

    @Override
    public int getAvailableCapacity() {
        return maxContainerCapacity - containerList.size();
    }

    @Override
    public String getTrackingId() {
        return shipId;
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
        return "Ship{" +
                "id='" + shipId + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", captain=" + (captain != null ? captain.getFullName() : "None") +
                ", status=" + currentStatus +
                ", location='" + currentLocation + '\'' +
                ", containers=" + containerList.size() + "/" + maxContainerCapacity +
                ", weight=" + currentWeight + "/" + maxWeightCapacity + " tonnes" +
                ", inTransit=" + inTransit +
                '}';
    }
}
