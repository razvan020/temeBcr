package model;

import model.employees.Worker;
import model.enums.PortType;
import model.interfaces.ContainerManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Port implements ContainerManager {
    private final String portId;
    private final String name;
    private final String location;
    private final PortType type;
    private final int maxContainerCapacity;
    private final int maxShipCapacity;
    private Map<String, Container> containerMap;
    private List<Container> containerList;
    private List<Ship> dockedShips;
    private List<Worker> workers;
    private List<LoadingArea> loadingAreas;

    public Port(String name, String location, PortType type, int maxContainerCapacity, int maxShipCapacity) {
        this.portId = "PORT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.name = name;
        this.location = location;
        this.type = type;
        this.maxContainerCapacity = maxContainerCapacity;
        this.maxShipCapacity = maxShipCapacity;
        this.containerMap = new HashMap<>();
        this.containerList = new ArrayList<>();
        this.dockedShips = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.loadingAreas = new ArrayList<>();
    }

    public String getPortId() {
        return portId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public PortType getType() {
        return type;
    }

    public int getMaxShipCapacity() {
        return maxShipCapacity;
    }

    public int getDockedShipCount() {
        return dockedShips.size();
    }

    public List<Ship> getDockedShips() {
        return new ArrayList<>(dockedShips);
    }

    public boolean dockShip(Ship ship) {
        if (dockedShips.size() >= maxShipCapacity) {
            return false;
        }

        dockedShips.add(ship);
        ship.updateLocation(name);
        return true;
    }

    public boolean undockShip(Ship ship, String destination) {
        if (dockedShips.remove(ship)) {
            ship.setInTransit(true);
            ship.setDestination(destination);
            ship.updateLocation("En route from " + name + " to " + destination);
            return true;
        }
        return false;
    }

    public boolean undockShip(Ship ship) {
        return undockShip(ship, "Unknown destination");
    }

    public boolean startShipVoyage(Ship ship, String destination, LocalDateTime departureTime, LocalDateTime estimatedArrivalTime) {
        if (!dockedShips.contains(ship)) {
            return false;
        }

        if (ship.startVoyage(destination, departureTime, estimatedArrivalTime)) {
            dockedShips.remove(ship);
            ship.updateLocation("En route from " + name + " to " + destination);
            return true;
        }

        return false;
    }

    public List<Worker> getWorkers() {
        return new ArrayList<>(workers);
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public boolean removeWorker(Worker worker) {
        return workers.remove(worker);
    }

    public List<LoadingArea> getLoadingAreas() {
        return new ArrayList<>(loadingAreas);
    }

    public void addLoadingArea(LoadingArea loadingArea) {
        loadingAreas.add(loadingArea);
    }

    public boolean removeLoadingArea(LoadingArea loadingArea) {
        return loadingAreas.remove(loadingArea);
    }

    public boolean transferContainerToShip(Container container, Ship ship) {
        if (!containerList.contains(container) || !dockedShips.contains(ship)) {
            return false;
        }

        if (ship.addContainer(container)) {
            removeContainer(container);
            container.updateLocation("On ship: " + ship.getName());
            return true;
        }

        return false;
    }

    public boolean transferContainerFromShip(Container container, Ship ship) {
        if (!dockedShips.contains(ship) || !ship.getAllContainers().contains(container)) {
            return false;
        }

        if (containerList.size() < maxContainerCapacity) {
            if (ship.removeContainer(container)) {
                addContainer(container);
                container.updateLocation("At port: " + name);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addContainer(Container container) {
        if (containerList.size() >= maxContainerCapacity) {
            return false;
        }

        containerList.add(container);
        containerMap.put(container.getTrackingId(), container);
        container.updateLocation("At port: " + name);
        return true;
    }

    @Override
    public boolean removeContainer(Container container) {
        if (containerList.remove(container)) {
            containerMap.remove(container.getTrackingId());
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
    public String toString() {
        return "Port{" +
                "id='" + portId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type=" + type +
                ", containers=" + containerList.size() + "/" + maxContainerCapacity +
                ", ships=" + dockedShips.size() + "/" + maxShipCapacity +
                ", workers=" + workers.size() +
                ", loadingAreas=" + loadingAreas.size() +
                '}';
    }
}