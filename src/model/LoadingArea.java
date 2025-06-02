package model;

import model.employees.Worker;
import model.interfaces.ContainerManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LoadingArea implements ContainerManager {
    private final String loadingAreaId;
    private final String name;
    private final int maxContainerCapacity;
    private final boolean hasRefrigerationCapability;
    private final boolean hasHazardousMaterialCapability;
    private final boolean hasOversizedCapability;
    private Map<String, Container> containerMap;
    private List<Container> containerList;
    private List<Worker> assignedWorkers;
    private boolean operational;

    public LoadingArea(String name, int maxContainerCapacity, boolean hasRefrigerationCapability,
                      boolean hasHazardousMaterialCapability, boolean hasOversizedCapability) {
        this.loadingAreaId = "LOAD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.name = name;
        this.maxContainerCapacity = maxContainerCapacity;
        this.hasRefrigerationCapability = hasRefrigerationCapability;
        this.hasHazardousMaterialCapability = hasHazardousMaterialCapability;
        this.hasOversizedCapability = hasOversizedCapability;
        this.containerMap = new HashMap<>();
        this.containerList = new ArrayList<>();
        this.assignedWorkers = new ArrayList<>();
        this.operational = true;
    }

    public String getLoadingAreaId() {
        return loadingAreaId;
    }

    public String getName() {
        return name;
    }

    public boolean hasRefrigerationCapability() {
        return hasRefrigerationCapability;
    }

    public boolean hasHazardousMaterialCapability() {
        return hasHazardousMaterialCapability;
    }

    public boolean hasOversizedCapability() {
        return hasOversizedCapability;
    }

    public boolean isOperational() {
        return operational;
    }

    public void setOperational(boolean operational) {
        this.operational = operational;
    }

    public List<Worker> getAssignedWorkers() {
        return new ArrayList<>(assignedWorkers);
    }

    public void assignWorker(Worker worker) {
        assignedWorkers.add(worker);
    }

    public boolean removeWorker(Worker worker) {
        return assignedWorkers.remove(worker);
    }

    public boolean canHandleContainer(Container container) {
        if (!operational) {
            return false;
        }

        if (container.getType().toString().contains("Refrigerated") && !hasRefrigerationCapability) {
            return false;
        }

        boolean containsHazardousCargo = container.getCargoList().stream()
                .anyMatch(cargo -> cargo.isHazardous());
        if (containsHazardousCargo && !hasHazardousMaterialCapability) {
            return false;
        }

        if (container.getLength() > 12 && !hasOversizedCapability) {
            return false;
        }

        return true;
    }

    @Override
    public boolean addContainer(Container container) {
        if (!operational || containerList.size() >= maxContainerCapacity || !canHandleContainer(container)) {
            return false;
        }

        containerList.add(container);
        containerMap.put(container.getTrackingId(), container);
        container.updateLocation("At loading area: " + name);
        return true;
    }

    @Override
    public boolean removeContainer(Container container) {
        if (!operational) {
            return false;
        }

        if (containerList.remove(container)) {
            containerMap.remove(container.getTrackingId());
            return true;
        }
        return false;
    }

    @Override
    public boolean removeContainer(String containerId) {
        if (!operational) {
            return false;
        }

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
        return operational && containerList.size() < maxContainerCapacity;
    }

    @Override
    public int getAvailableCapacity() {
        if (!operational) {
            return 0;
        }
        return maxContainerCapacity - containerList.size();
    }

    @Override
    public String toString() {
        return "LoadingArea{" +
                "id='" + loadingAreaId + '\'' +
                ", name='" + name + '\'' +
                ", operational=" + operational +
                ", containers=" + containerList.size() + "/" + maxContainerCapacity +
                ", workers=" + assignedWorkers.size() +
                ", refrigeration=" + hasRefrigerationCapability +
                ", hazardous=" + hasHazardousMaterialCapability +
                ", oversized=" + hasOversizedCapability +
                '}';
    }
}