package model.interfaces;

import model.Container;
import java.util.List;


public interface ContainerManager {

    boolean addContainer(Container container);

    boolean removeContainer(Container container);

    boolean removeContainer(String containerId);

    List<Container> getAllContainers();

    int getContainerCount();

    int getMaxCapacity();

    boolean hasAvailableCapacity();

    int getAvailableCapacity();
}