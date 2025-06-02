import model.*;
import model.employees.Captain;
import model.employees.Worker;
import model.enums.ContainerType;
import model.enums.PortType;
import model.enums.ShipType;
import model.enums.ShippingStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Port> ports = new HashMap<>();
    private static Map<String, Ship> ships = new HashMap<>();
    private static Map<String, Container> containers = new HashMap<>();
    private static Map<String, Cargo> cargos = new HashMap<>();
    private static Map<String, Captain> captains = new HashMap<>();
    private static Map<String, Worker> workers = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Shipping Container Tracker System");
        initializeDemoData();
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getUserChoice(1, 8);

            switch (choice) {
                case 1:
                    portManagementMenu();
                    break;
                case 2:
                    shipManagementMenu();
                    break;
                case 3:
                    containerManagementMenu();
                    break;
                case 4:
                    cargoManagementMenu();
                    break;
                case 5:
                    employeeManagementMenu();
                    break;
                case 6:
                    trackingMenu();
                    break;
                case 7:
                    simulateShippingOperations();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using the Shipping Container Tracker System!");
                    break;
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Port Management");
        System.out.println("2. Ship Management");
        System.out.println("3. Container Management");
        System.out.println("4. Cargo Management");
        System.out.println("5. Employee Management");
        System.out.println("6. Tracking");
        System.out.println("7. Simulate Shipping Operations");
        System.out.println("8. Exit");
        System.out.print("Enter your choice (1-8): ");
    }

    private static void portManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nPort Management Menu:");
            System.out.println("1. View All Ports");
            System.out.println("2. Create New Port");
            System.out.println("3. Add Loading Area to Port");
            System.out.println("4. View Port Details");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = getUserChoice(1, 5);

            switch (choice) {
                case 1:
                    viewAllPorts();
                    break;
                case 2:
                    createNewPort();
                    break;
                case 3:
                    addLoadingAreaToPort();
                    break;
                case 4:
                    viewPortDetails();
                    break;
                case 5:
                    back = true;
                    break;
            }
        }
    }

    private static void shipManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nShip Management Menu:");
            System.out.println("1. View All Ships");
            System.out.println("2. Create New Ship");
            System.out.println("3. Assign Captain to Ship");
            System.out.println("4. Dock Ship at Port");
            System.out.println("5. View Ship Details");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice (1-6): ");

            int choice = getUserChoice(1, 6);

            switch (choice) {
                case 1:
                    viewAllShips();
                    break;
                case 2:
                    createNewShip();
                    break;
                case 3:
                    assignCaptainToShip();
                    break;
                case 4:
                    dockShipAtPort();
                    break;
                case 5:
                    viewShipDetails();
                    break;
                case 6:
                    back = true;
                    break;
            }
        }
    }

    private static void containerManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nContainer Management Menu:");
            System.out.println("1. View All Containers");
            System.out.println("2. Create New Container");
            System.out.println("3. Add Cargo to Container");
            System.out.println("4. Seal/Unseal Container");
            System.out.println("5. View Container Details");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice (1-6): ");

            int choice = getUserChoice(1, 6);

            switch (choice) {
                case 1:
                    viewAllContainers();
                    break;
                case 2:
                    createNewContainer();
                    break;
                case 3:
                    addCargoToContainer();
                    break;
                case 4:
                    sealUnsealContainer();
                    break;
                case 5:
                    viewContainerDetails();
                    break;
                case 6:
                    back = true;
                    break;
            }
        }
    }

    private static void cargoManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nCargo Management Menu:");
            System.out.println("1. View All Cargo");
            System.out.println("2. Create New Cargo");
            System.out.println("3. Update Cargo Status");
            System.out.println("4. View Cargo Details");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = getUserChoice(1, 5);

            switch (choice) {
                case 1:
                    viewAllCargo();
                    break;
                case 2:
                    createNewCargo();
                    break;
                case 3:
                    updateCargoStatus();
                    break;
                case 4:
                    viewCargoDetails();
                    break;
                case 5:
                    back = true;
                    break;
            }
        }
    }

    private static void employeeManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nEmployee Management Menu:");
            System.out.println("1. View All Employees");
            System.out.println("2. Create New Captain");
            System.out.println("3. Create New Worker");
            System.out.println("4. Add Skill/Certification");
            System.out.println("5. Calculate Employee Bonus");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice (1-6): ");

            int choice = getUserChoice(1, 6);

            switch (choice) {
                case 1:
                    viewAllEmployees();
                    break;
                case 2:
                    createNewCaptain();
                    break;
                case 3:
                    createNewWorker();
                    break;
                case 4:
                    addSkillOrCertification();
                    break;
                case 5:
                    calculateEmployeeBonus();
                    break;
                case 6:
                    back = true;
                    break;
            }
        }
    }

    private static void trackingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\nTracking Menu:");
            System.out.println("1. Track Ship");
            System.out.println("2. Track Container");
            System.out.println("3. Track Cargo");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice (1-4): ");

            int choice = getUserChoice(1, 4);

            switch (choice) {
                case 1:
                    trackShip();
                    break;
                case 2:
                    trackContainer();
                    break;
                case 3:
                    trackCargo();
                    break;
                case 4:
                    back = true;
                    break;
            }
        }
    }

    private static void simulateShippingOperations() {
        System.out.println("\nSimulate Shipping Operations:");
        System.out.println("1. Start Voyage");
        System.out.println("2. Complete Voyage");
        System.out.println("3. Transfer Container to Ship");
        System.out.println("4. Transfer Container to Port");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice (1-5): ");

        int choice = getUserChoice(1, 5);

        switch (choice) {
            case 1:
                startVoyage();
                break;
            case 2:
                completeVoyage();
                break;
            case 3:
                transferContainerToShip();
                break;
            case 4:
                transferContainerToPort();
                break;
            case 5:
                break;
        }
    }

    private static void viewAllPorts() {
        System.out.println("\nAll Ports:");
        if (ports.isEmpty()) {
            System.out.println("No ports available.");
        } else {
            for (Port port : ports.values()) {
                System.out.println(port);
            }
        }
    }

    private static void createNewPort() {
        System.out.println("\nCreate New Port:");
        System.out.print("Enter port name: ");
        String name = scanner.nextLine();

        System.out.print("Enter port location: ");
        String location = scanner.nextLine();

        System.out.println("Available port types:");
        for (PortType type : PortType.values()) {
            System.out.println(type.ordinal() + 1 + ". " + type);
        }
        System.out.print("Select port type (1-" + PortType.values().length + "): ");
        int typeChoice = getUserChoice(1, PortType.values().length);
        PortType portType = PortType.values()[typeChoice - 1];

        System.out.print("Enter maximum container capacity: ");
        int maxContainerCapacity = getPositiveIntInput();

        System.out.print("Enter maximum ship capacity: ");
        int maxShipCapacity = getPositiveIntInput();

        Port newPort = new Port(name, location, portType, maxContainerCapacity, maxShipCapacity);
        ports.put(newPort.getPortId(), newPort);

        System.out.println("Port created successfully: " + newPort);
    }

    private static void addLoadingAreaToPort() {
        if (ports.isEmpty()) {
            System.out.println("\nNo ports available. Please create a port first.");
            return;
        }

        System.out.println("\nAdd Loading Area to Port:");
        Port selectedPort = selectPort();
        if (selectedPort == null) return;

        System.out.print("Enter loading area name: ");
        String name = scanner.nextLine();

        System.out.print("Enter maximum container capacity: ");
        int maxContainerCapacity = getPositiveIntInput();

        System.out.print("Does this loading area have refrigeration capability? (y/n): ");
        boolean hasRefrigerationCapability = getUserYesNoInput();

        System.out.print("Does this loading area have hazardous material capability? (y/n): ");
        boolean hasHazardousMaterialCapability = getUserYesNoInput();

        System.out.print("Does this loading area have oversized capability? (y/n): ");
        boolean hasOversizedCapability = getUserYesNoInput();

        LoadingArea newLoadingArea = new LoadingArea(name, maxContainerCapacity, 
                hasRefrigerationCapability, hasHazardousMaterialCapability, hasOversizedCapability);

        selectedPort.addLoadingArea(newLoadingArea);
        System.out.println("Loading area added successfully: " + newLoadingArea);
    }

    private static void viewPortDetails() {
        if (ports.isEmpty()) {
            System.out.println("\nNo ports available.");
            return;
        }

        System.out.println("\nView Port Details:");
        Port selectedPort = selectPort();
        if (selectedPort == null) return;

        System.out.println("\nPort Details:");
        System.out.println(selectedPort);

        System.out.println("\nLoading Areas:");
        List<LoadingArea> loadingAreas = selectedPort.getLoadingAreas();
        if (loadingAreas.isEmpty()) {
            System.out.println("No loading areas available for this port.");
        } else {
            for (LoadingArea area : loadingAreas) {
                System.out.println(area);
            }
        }

        System.out.println("\nDocked Ships:");
        List<Ship> dockedShips = selectedPort.getDockedShips();
        if (dockedShips.isEmpty()) {
            System.out.println("No ships currently docked at this port.");
        } else {
            for (Ship ship : dockedShips) {
                System.out.println(ship);
            }
        }

        System.out.println("\nWorkers Assigned to Port:");
        List<Worker> portWorkers = selectedPort.getWorkers();
        if (portWorkers.isEmpty()) {
            System.out.println("No workers assigned to this port.");
        } else {
            for (Worker worker : portWorkers) {
                System.out.println(worker);
            }
        }
    }

    private static void viewAllShips() {
        System.out.println("\nAll Ships:");
        if (ships.isEmpty()) {
            System.out.println("No ships available.");
        } else {
            for (Ship ship : ships.values()) {
                System.out.println(ship);
            }
        }
    }

    private static void createNewShip() {
        System.out.println("\nCreate New Ship:");
        System.out.print("Enter ship name: ");
        String name = scanner.nextLine();

        System.out.println("Available ship types:");
        for (ShipType type : ShipType.values()) {
            System.out.println(type.ordinal() + 1 + ". " + type);
        }
        System.out.print("Select ship type (1-" + ShipType.values().length + "): ");
        int typeChoice = getUserChoice(1, ShipType.values().length);
        ShipType shipType = ShipType.values()[typeChoice - 1];

        System.out.print("Enter maximum container capacity: ");
        int maxContainerCapacity = getPositiveIntInput();

        System.out.print("Enter maximum weight capacity (in tonnes): ");
        double maxWeightCapacity = getPositiveDoubleInput();

        Ship newShip = new Ship(name, shipType, maxContainerCapacity, maxWeightCapacity);
        ships.put(newShip.getTrackingId(), newShip);

        System.out.println("Ship created successfully: " + newShip);
    }

    private static void assignCaptainToShip() {
        if (ships.isEmpty()) {
            System.out.println("\nNo ships available. Please create a ship first.");
            return;
        }

        if (captains.isEmpty()) {
            System.out.println("\nNo captains available. Please create a captain first.");
            return;
        }

        System.out.println("\nAssign Captain to Ship:");
        Ship selectedShip = selectShip();
        if (selectedShip == null) return;

        Captain selectedCaptain = selectCaptain();
        if (selectedCaptain == null) return;

        selectedShip.setCaptain(selectedCaptain);
        System.out.println("Captain " + selectedCaptain.getFullName() + " assigned to ship " + selectedShip.getName());
    }

    private static void dockShipAtPort() {
        if (ships.isEmpty()) {
            System.out.println("\nNo ships available. Please create a ship first.");
            return;
        }

        if (ports.isEmpty()) {
            System.out.println("\nNo ports available. Please create a port first.");
            return;
        }

        System.out.println("\nDock Ship at Port:");
        Ship selectedShip = selectShip();
        if (selectedShip == null) return;

        Port selectedPort = selectPort();
        if (selectedPort == null) return;

        boolean success = selectedPort.dockShip(selectedShip);
        if (success) {
            System.out.println("Ship " + selectedShip.getName() + " docked at " + selectedPort.getName());
        } else {
            System.out.println("Failed to dock ship. The port may be at maximum capacity.");
        }
    }

    private static void viewShipDetails() {
        if (ships.isEmpty()) {
            System.out.println("\nNo ships available.");
            return;
        }

        System.out.println("\nView Ship Details:");
        Ship selectedShip = selectShip();
        if (selectedShip == null) return;

        System.out.println("\nShip Details:");
        System.out.println(selectedShip);

        System.out.println("\nCaptain:");
        Captain captain = selectedShip.getCaptain();
        if (captain == null) {
            System.out.println("No captain assigned to this ship.");
        } else {
            System.out.println(captain);
        }

        System.out.println("\nContainers on Ship:");
        List<Container> shipContainers = selectedShip.getAllContainers();
        if (shipContainers.isEmpty()) {
            System.out.println("No containers on this ship.");
        } else {
            for (Container container : shipContainers) {
                System.out.println(container);
            }
        }

        System.out.println("\nCurrent Status: " + selectedShip.getCurrentStatus());
        System.out.println("Current Location: " + selectedShip.getCurrentLocation());
        if (selectedShip.isInTransit()) {
            System.out.println("Destination: " + selectedShip.getDestination());
            System.out.println("Departure Time: " + formatDateTime(selectedShip.getDepartureTime()));
            System.out.println("Estimated Arrival Time: " + formatDateTime(selectedShip.getEstimatedArrivalTime()));
        }
    }

    private static void viewAllContainers() {
        System.out.println("\nAll Containers:");
        if (containers.isEmpty()) {
            System.out.println("No containers available.");
        } else {
            for (Container container : containers.values()) {
                System.out.println(container);
            }
        }
    }

    private static void createNewContainer() {
        System.out.println("\nCreate New Container:");

        System.out.println("Available container types:");
        for (ContainerType type : ContainerType.values()) {
            System.out.println(type.ordinal() + 1 + ". " + type);
        }
        System.out.print("Select container type (1-" + ContainerType.values().length + "): ");
        int typeChoice = getUserChoice(1, ContainerType.values().length);
        ContainerType containerType = ContainerType.values()[typeChoice - 1];

        System.out.print("Enter maximum weight capacity (in tonnes): ");
        double maxWeightCapacity = getPositiveDoubleInput();

        System.out.print("Enter length (in meters): ");
        double length = getPositiveDoubleInput();

        System.out.print("Enter width (in meters): ");
        double width = getPositiveDoubleInput();

        System.out.print("Enter height (in meters): ");
        double height = getPositiveDoubleInput();

        Container newContainer = new Container(containerType, maxWeightCapacity, length, width, height);
        containers.put(newContainer.getTrackingId(), newContainer);

        System.out.println("Container created successfully: " + newContainer);
    }

    private static void addCargoToContainer() {
        if (containers.isEmpty()) {
            System.out.println("\nNo containers available. Please create a container first.");
            return;
        }

        if (cargos.isEmpty()) {
            System.out.println("\nNo cargo available. Please create cargo first.");
            return;
        }

        System.out.println("\nAdd Cargo to Container:");
        Container selectedContainer = selectContainer();
        if (selectedContainer == null) return;

        if (selectedContainer.isSealed()) {
            System.out.println("Cannot add cargo to a sealed container. Please unseal it first.");
            return;
        }

        Cargo selectedCargo = selectCargo();
        if (selectedCargo == null) return;

        boolean success = selectedContainer.addCargo(selectedCargo);
        if (success) {
            System.out.println("Cargo " + selectedCargo.getDescription() + " added to container " + selectedContainer.getTrackingId());
        } else {
            System.out.println("Failed to add cargo. The container may be at maximum weight capacity.");
        }
    }

    private static void sealUnsealContainer() {
        if (containers.isEmpty()) {
            System.out.println("\nNo containers available. Please create a container first.");
            return;
        }

        System.out.println("\nSeal/Unseal Container:");
        Container selectedContainer = selectContainer();
        if (selectedContainer == null) return;

        if (selectedContainer.isSealed()) {
            System.out.print("Container is currently sealed. Do you want to unseal it? (y/n): ");
            if (getUserYesNoInput()) {
                selectedContainer.unseal();
                System.out.println("Container unsealed successfully.");
            }
        } else {
            System.out.print("Container is currently unsealed. Do you want to seal it? (y/n): ");
            if (getUserYesNoInput()) {
                selectedContainer.seal();
                System.out.println("Container sealed successfully.");
            }
        }
    }

    private static void viewContainerDetails() {
        if (containers.isEmpty()) {
            System.out.println("\nNo containers available.");
            return;
        }

        System.out.println("\nView Container Details:");
        Container selectedContainer = selectContainer();
        if (selectedContainer == null) return;

        System.out.println("\nContainer Details:");
        System.out.println(selectedContainer);

        System.out.println("\nCargo in Container:");
        List<Cargo> containerCargo = selectedContainer.getCargoList();
        if (containerCargo.isEmpty()) {
            System.out.println("No cargo in this container.");
        } else {
            for (Cargo cargo : containerCargo) {
                System.out.println(cargo);
            }
        }

        System.out.println("\nSealed: " + (selectedContainer.isSealed() ? "Yes" : "No"));
        System.out.println("Current Status: " + selectedContainer.getCurrentStatus());
        System.out.println("Current Location: " + selectedContainer.getCurrentLocation());
        System.out.println("Available Weight Capacity: " + selectedContainer.getAvailableCapacity() + " tonnes");
        System.out.println("Volume: " + selectedContainer.getVolume() + " cubic meters");
    }

    private static void viewAllCargo() {
        System.out.println("\nAll Cargo:");
        if (cargos.isEmpty()) {
            System.out.println("No cargo available.");
        } else {
            for (Cargo cargo : cargos.values()) {
                System.out.println(cargo);
            }
        }
    }

    private static void createNewCargo() {
        System.out.println("\nCreate New Cargo:");
        System.out.print("Enter cargo description: ");
        String description = scanner.nextLine();

        System.out.print("Enter weight (in tonnes): ");
        double weight = getPositiveDoubleInput();

        System.out.print("Enter volume (in cubic meters): ");
        double volume = getPositiveDoubleInput();

        System.out.print("Is this cargo hazardous? (y/n): ");
        boolean hazardous = getUserYesNoInput();

        System.out.print("Is this cargo fragile? (y/n): ");
        boolean fragile = getUserYesNoInput();

        System.out.print("Is this cargo perishable? (y/n): ");
        boolean perishable = getUserYesNoInput();

        LocalDateTime expiryDate = null;
        if (perishable) {
            System.out.print("Enter expiry date (yyyy-MM-dd): ");
            expiryDate = getDateInput().atStartOfDay();
        }

        System.out.print("Enter sender name: ");
        String sender = scanner.nextLine();

        System.out.print("Enter recipient name: ");
        String recipient = scanner.nextLine();

        System.out.print("Enter destination address: ");
        String destinationAddress = scanner.nextLine();

        Cargo newCargo = new Cargo(description, weight, volume, hazardous, fragile, perishable, 
                expiryDate, sender, recipient, destinationAddress);
        cargos.put(newCargo.getTrackingId(), newCargo);

        System.out.println("Cargo created successfully: " + newCargo);
    }

    private static void updateCargoStatus() {
        if (cargos.isEmpty()) {
            System.out.println("\nNo cargo available. Please create cargo first.");
            return;
        }

        System.out.println("\nUpdate Cargo Status:");
        Cargo selectedCargo = selectCargo();
        if (selectedCargo == null) return;

        System.out.println("Current status: " + selectedCargo.getCurrentStatus());

        System.out.println("Available statuses:");
        for (ShippingStatus status : ShippingStatus.values()) {
            System.out.println(status.ordinal() + 1 + ". " + status);
        }
        System.out.print("Select new status (1-" + ShippingStatus.values().length + "): ");
        int statusChoice = getUserChoice(1, ShippingStatus.values().length);
        ShippingStatus newStatus = ShippingStatus.values()[statusChoice - 1];

        selectedCargo.updateStatus(newStatus);
        System.out.println("Cargo status updated to: " + newStatus);
    }

    private static void viewCargoDetails() {
        if (cargos.isEmpty()) {
            System.out.println("\nNo cargo available.");
            return;
        }

        System.out.println("\nView Cargo Details:");
        Cargo selectedCargo = selectCargo();
        if (selectedCargo == null) return;

        System.out.println("\nCargo Details:");
        System.out.println(selectedCargo);
        System.out.println("Tracking ID: " + selectedCargo.getTrackingId());
        System.out.println("Description: " + selectedCargo.getDescription());
        System.out.println("Weight: " + selectedCargo.getWeight() + " tonnes");
        System.out.println("Volume: " + selectedCargo.getVolume() + " cubic meters");
        System.out.println("Hazardous: " + (selectedCargo.isHazardous() ? "Yes" : "No"));
        System.out.println("Fragile: " + (selectedCargo.isFragile() ? "Yes" : "No"));
        System.out.println("Perishable: " + (selectedCargo.isPerishable() ? "Yes" : "No"));

        if (selectedCargo.isPerishable()) {
            System.out.println("Expiry Date: " + formatDateTime(selectedCargo.getExpiryDate()));
            System.out.println("Expired: " + (selectedCargo.isExpired() ? "Yes" : "No"));
        }

        System.out.println("Sender: " + selectedCargo.getSender());
        System.out.println("Recipient: " + selectedCargo.getRecipient());
        System.out.println("Destination Address: " + selectedCargo.getDestinationAddress());
        System.out.println("Current Status: " + selectedCargo.getCurrentStatus());
        System.out.println("Current Location: " + selectedCargo.getCurrentLocation());
        System.out.println("Last Updated: " + formatDateTime(selectedCargo.getLastUpdated()));
    }

    private static void viewAllEmployees() {
        System.out.println("\nAll Captains:");
        if (captains.isEmpty()) {
            System.out.println("No captains available.");
        } else {
            for (Captain captain : captains.values()) {
                System.out.println(captain);
            }
        }

        System.out.println("\nAll Workers:");
        if (workers.isEmpty()) {
            System.out.println("No workers available.");
        } else {
            for (Worker worker : workers.values()) {
                System.out.println(worker);
            }
        }
    }

    private static void createNewCaptain() {
        System.out.println("\nCreate New Captain:");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        LocalDate dateOfBirth = getDateInput();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter hire date (yyyy-MM-dd): ");
        LocalDate hireDate = getDateInput();

        System.out.print("Enter salary: ");
        double salary = getPositiveDoubleInput();

        System.out.print("Enter years of experience: ");
        int yearsOfExperience = getPositiveIntInput();

        Captain newCaptain = new Captain(firstName, lastName, dateOfBirth, address, phoneNumber, 
                email, hireDate, salary, yearsOfExperience);
        captains.put(newCaptain.getEmployeeId(), newCaptain);

        System.out.println("Captain created successfully: " + newCaptain);
    }

    private static void createNewWorker() {
        System.out.println("\nCreate New Worker:");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        LocalDate dateOfBirth = getDateInput();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter hire date (yyyy-MM-dd): ");
        LocalDate hireDate = getDateInput();

        System.out.print("Enter salary: ");
        double salary = getPositiveDoubleInput();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter job role: ");
        String jobRole = scanner.nextLine();

        System.out.print("Enter supervisor name: ");
        String supervisor = scanner.nextLine();

        System.out.print("Is this worker a shift worker? (y/n): ");
        boolean isShiftWorker = getUserYesNoInput();

        Worker newWorker = new Worker(firstName, lastName, dateOfBirth, address, phoneNumber, 
                email, hireDate, salary, department, jobRole, supervisor, isShiftWorker);
        workers.put(newWorker.getEmployeeId(), newWorker);

        System.out.println("Worker created successfully: " + newWorker);
    }

    private static void addSkillOrCertification() {
        System.out.println("\nAdd Skill or Certification:");
        System.out.println("1. Add Skill to Worker");
        System.out.println("2. Add Certification to Captain");
        System.out.println("3. Add License to Captain");
        System.out.print("Enter your choice (1-3): ");

        int choice = getUserChoice(1, 3);

        switch (choice) {
            case 1:
                addSkillToWorker();
                break;
            case 2:
                addCertificationToCaptain();
                break;
            case 3:
                addLicenseToCaptain();
                break;
        }
    }

    private static void addSkillToWorker() {
        if (workers.isEmpty()) {
            System.out.println("\nNo workers available. Please create a worker first.");
            return;
        }

        System.out.println("\nAdd Skill to Worker:");
        Worker selectedWorker = selectWorker();
        if (selectedWorker == null) return;

        System.out.print("Enter skill to add: ");
        String skill = scanner.nextLine();

        selectedWorker.addSkill(skill);
        System.out.println("Skill '" + skill + "' added to worker " + selectedWorker.getFullName());
    }

    private static void addCertificationToCaptain() {
        if (captains.isEmpty()) {
            System.out.println("\nNo captains available. Please create a captain first.");
            return;
        }

        System.out.println("\nAdd Certification to Captain:");
        Captain selectedCaptain = selectCaptain();
        if (selectedCaptain == null) return;

        System.out.print("Enter certification to add: ");
        String certification = scanner.nextLine();

        selectedCaptain.addCertification(certification);
        System.out.println("Certification '" + certification + "' added to captain " + selectedCaptain.getFullName());
    }

    private static void addLicenseToCaptain() {
        if (captains.isEmpty()) {
            System.out.println("\nNo captains available. Please create a captain first.");
            return;
        }

        System.out.println("\nAdd License to Captain:");
        Captain selectedCaptain = selectCaptain();
        if (selectedCaptain == null) return;

        System.out.print("Enter license to add: ");
        String license = scanner.nextLine();

        selectedCaptain.addLicense(license);
        System.out.println("License '" + license + "' added to captain " + selectedCaptain.getFullName());
    }

    private static void calculateEmployeeBonus() {
        System.out.println("\nCalculate Employee Bonus:");
        System.out.println("1. Calculate Captain Bonus");
        System.out.println("2. Calculate Worker Bonus");
        System.out.print("Enter your choice (1-2): ");

        int choice = getUserChoice(1, 2);

        switch (choice) {
            case 1:
                calculateCaptainBonus();
                break;
            case 2:
                calculateWorkerBonus();
                break;
        }
    }

    private static void calculateCaptainBonus() {
        if (captains.isEmpty()) {
            System.out.println("\nNo captains available. Please create a captain first.");
            return;
        }

        System.out.println("\nCalculate Captain Bonus:");
        Captain selectedCaptain = selectCaptain();
        if (selectedCaptain == null) return;

        double bonus = selectedCaptain.calculateBonus();
        System.out.println("Captain " + selectedCaptain.getFullName() + " bonus: $" + bonus);
    }

    private static void calculateWorkerBonus() {
        if (workers.isEmpty()) {
            System.out.println("\nNo workers available. Please create a worker first.");
            return;
        }

        System.out.println("\nCalculate Worker Bonus:");
        Worker selectedWorker = selectWorker();
        if (selectedWorker == null) return;

        double bonus = selectedWorker.calculateBonus();
        System.out.println("Worker " + selectedWorker.getFullName() + " bonus: $" + bonus);
    }

    private static void trackShip() {
        if (ships.isEmpty()) {
            System.out.println("\nNo ships available. Please create a ship first.");
            return;
        }

        System.out.println("\nTrack Ship:");
        System.out.print("Enter ship tracking ID or name: ");
        String identifier = scanner.nextLine();

        Ship ship = null;
        for (Ship s : ships.values()) {
            if (s.getTrackingId().equals(identifier) || s.getName().equalsIgnoreCase(identifier)) {
                ship = s;
                break;
            }
        }

        if (ship == null) {
            System.out.println("Ship not found with ID or name: " + identifier);
            return;
        }

        System.out.println("\nShip Tracking Information:");
        System.out.println("ID: " + ship.getTrackingId());
        System.out.println("Name: " + ship.getName());
        System.out.println("Type: " + ship.getType());
        System.out.println("Status: " + ship.getCurrentStatus());
        System.out.println("Location: " + ship.getCurrentLocation());

        if (ship.isInTransit()) {
            System.out.println("Destination: " + ship.getDestination());
            System.out.println("Departure Time: " + formatDateTime(ship.getDepartureTime()));
            System.out.println("Estimated Arrival Time: " + formatDateTime(ship.getEstimatedArrivalTime()));
        }

        System.out.println("Last Updated: " + formatDateTime(ship.getLastUpdated()));
    }

    private static void trackContainer() {
        if (containers.isEmpty()) {
            System.out.println("\nNo containers available. Please create a container first.");
            return;
        }

        System.out.println("\nTrack Container:");
        System.out.print("Enter container tracking ID: ");
        String trackingId = scanner.nextLine();

        Container container = containers.get(trackingId);
        if (container == null) {
            System.out.println("Container not found with ID: " + trackingId);
            return;
        }

        System.out.println("\nContainer Tracking Information:");
        System.out.println("ID: " + container.getTrackingId());
        System.out.println("Type: " + container.getType());
        System.out.println("Status: " + container.getCurrentStatus());
        System.out.println("Location: " + container.getCurrentLocation());
        System.out.println("Sealed: " + (container.isSealed() ? "Yes" : "No"));
        System.out.println("Last Updated: " + formatDateTime(container.getLastUpdated()));
    }

    private static void trackCargo() {
        if (cargos.isEmpty()) {
            System.out.println("\nNo cargo available. Please create cargo first.");
            return;
        }

        System.out.println("\nTrack Cargo:");
        System.out.print("Enter cargo tracking ID: ");
        String trackingId = scanner.nextLine();

        Cargo cargo = cargos.get(trackingId);
        if (cargo == null) {
            System.out.println("Cargo not found with ID: " + trackingId);
            return;
        }

        System.out.println("\nCargo Tracking Information:");
        System.out.println("ID: " + cargo.getTrackingId());
        System.out.println("Description: " + cargo.getDescription());
        System.out.println("Status: " + cargo.getCurrentStatus());
        System.out.println("Location: " + cargo.getCurrentLocation());
        System.out.println("Sender: " + cargo.getSender());
        System.out.println("Recipient: " + cargo.getRecipient());
        System.out.println("Destination: " + cargo.getDestinationAddress());
        System.out.println("Last Updated: " + formatDateTime(cargo.getLastUpdated()));
    }

    private static void startVoyage() {
        if (ships.isEmpty()) {
            System.out.println("\nNo ships available. Please create a ship first.");
            return;
        }

        if (ports.isEmpty()) {
            System.out.println("\nNo ports available. Please create a port first.");
            return;
        }

        System.out.println("\nStart Voyage:");
        Port departurePort = selectPort();
        if (departurePort == null) return;

        List<Ship> dockedShips = departurePort.getDockedShips();
        if (dockedShips.isEmpty()) {
            System.out.println("No ships docked at this port.");
            return;
        }

        System.out.println("Ships docked at " + departurePort.getName() + ":");
        for (int i = 0; i < dockedShips.size(); i++) {
            System.out.println((i + 1) + ". " + dockedShips.get(i).getName());
        }

        System.out.print("Select ship to start voyage (1-" + dockedShips.size() + "): ");
        int shipChoice = getUserChoice(1, dockedShips.size());
        Ship selectedShip = dockedShips.get(shipChoice - 1);

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter estimated days for voyage: ");
        int days = getPositiveIntInput();

        boolean success = departurePort.startShipVoyage(
                selectedShip, 
                destination, 
                LocalDateTime.now(), 
                LocalDateTime.now().plusDays(days)
        );

        if (success) {
            System.out.println("Voyage started for ship " + selectedShip.getName() + " to " + destination);
        } else {
            System.out.println("Failed to start voyage. The ship may not have a captain assigned.");
        }
    }

    private static void completeVoyage() {
        if (ships.isEmpty()) {
            System.out.println("\nNo ships available. Please create a ship first.");
            return;
        }

        System.out.println("\nComplete Voyage:");

        List<Ship> shipsInTransit = new ArrayList<>();
        for (Ship ship : ships.values()) {
            if (ship.isInTransit()) {
                shipsInTransit.add(ship);
            }
        }

        if (shipsInTransit.isEmpty()) {
            System.out.println("No ships currently in transit.");
            return;
        }

        System.out.println("Ships in transit:");
        for (int i = 0; i < shipsInTransit.size(); i++) {
            Ship ship = shipsInTransit.get(i);
            System.out.println((i + 1) + ". " + ship.getName() + " (Destination: " + ship.getDestination() + ")");
        }

        System.out.print("Select ship to complete voyage (1-" + shipsInTransit.size() + "): ");
        int shipChoice = getUserChoice(1, shipsInTransit.size());
        Ship selectedShip = shipsInTransit.get(shipChoice - 1);

        System.out.print("Enter arrival location: ");
        String arrivalLocation = scanner.nextLine();

        selectedShip.completeVoyage(arrivalLocation);
        System.out.println("Voyage completed for ship " + selectedShip.getName() + " at " + arrivalLocation);

        System.out.print("Do you want to dock the ship at a port? (y/n): ");
        if (getUserYesNoInput()) {
            if (ports.isEmpty()) {
                System.out.println("No ports available. Please create a port first.");
                return;
            }

            Port selectedPort = selectPort();
            if (selectedPort == null) return;

            boolean success = selectedPort.dockShip(selectedShip);
            if (success) {
                System.out.println("Ship " + selectedShip.getName() + " docked at " + selectedPort.getName());
            } else {
                System.out.println("Failed to dock ship. The port may be at maximum capacity.");
            }
        }
    }

    private static void transferContainerToShip() {
        if (ships.isEmpty()) {
            System.out.println("\nNo ships available. Please create a ship first.");
            return;
        }

        if (containers.isEmpty()) {
            System.out.println("\nNo containers available. Please create a container first.");
            return;
        }

        System.out.println("\nTransfer Container to Ship:");
        Container selectedContainer = selectContainer();
        if (selectedContainer == null) return;

        Ship selectedShip = selectShip();
        if (selectedShip == null) return;

        boolean success = selectedShip.addContainer(selectedContainer);
        if (success) {
            System.out.println("Container " + selectedContainer.getTrackingId() + " transferred to ship " + selectedShip.getName());
            selectedContainer.updateLocation("On ship: " + selectedShip.getName());
        } else {
            System.out.println("Failed to transfer container. The ship may be at maximum capacity or weight limit.");
        }
    }

    private static void transferContainerToPort() {
        if (ports.isEmpty()) {
            System.out.println("\nNo ports available. Please create a port first.");
            return;
        }

        if (containers.isEmpty()) {
            System.out.println("\nNo containers available. Please create a container first.");
            return;
        }

        System.out.println("\nTransfer Container to Port:");
        Container selectedContainer = selectContainer();
        if (selectedContainer == null) return;

        Port selectedPort = selectPort();
        if (selectedPort == null) return;

        boolean success = selectedPort.addContainer(selectedContainer);
        if (success) {
            System.out.println("Container " + selectedContainer.getTrackingId() + " transferred to port " + selectedPort.getName());
        } else {
            System.out.println("Failed to transfer container. The port may be at maximum container capacity.");
        }
    }

    private static int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < min || choice > max) {
                    System.out.print("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return choice;
    }

    private static int getPositiveIntInput() {
        int value = -1;
        while (value <= 0) {
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value <= 0) {
                    System.out.print("Please enter a positive number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return value;
    }

    private static double getPositiveDoubleInput() {
        double value = -1;
        while (value <= 0) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0) {
                    System.out.print("Please enter a positive number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return value;
    }

    private static boolean getUserYesNoInput() {
        String input = "";
        while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
                System.out.print("Invalid input. Please enter 'y' or 'n': ");
            }
        }
        return input.equalsIgnoreCase("y");
    }

    private static LocalDate getDateInput() {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (date == null) {
            try {
                String input = scanner.nextLine();
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please use yyyy-MM-dd: ");
            }
        }

        return date;
    }

    private static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return "N/A";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        return dateTime.format(formatter);
    }

    private static Port selectPort() {
        System.out.println("Available ports:");
        List<Port> portList = new ArrayList<>(ports.values());
        for (int i = 0; i < portList.size(); i++) {
            System.out.println((i + 1) + ". " + portList.get(i).getName());
        }

        System.out.print("Select port (1-" + portList.size() + "): ");
        int portChoice = getUserChoice(1, portList.size());
        return portList.get(portChoice - 1);
    }

    private static Ship selectShip() {
        System.out.println("Available ships:");
        List<Ship> shipList = new ArrayList<>(ships.values());
        for (int i = 0; i < shipList.size(); i++) {
            System.out.println((i + 1) + ". " + shipList.get(i).getName());
        }

        System.out.print("Select ship (1-" + shipList.size() + "): ");
        int shipChoice = getUserChoice(1, shipList.size());
        return shipList.get(shipChoice - 1);
    }

    private static Container selectContainer() {
        System.out.println("Available containers:");
        List<Container> containerList = new ArrayList<>(containers.values());
        for (int i = 0; i < containerList.size(); i++) {
            System.out.println((i + 1) + ". " + containerList.get(i).getTrackingId() + " - " + containerList.get(i).getType());
        }

        System.out.print("Select container (1-" + containerList.size() + "): ");
        int containerChoice = getUserChoice(1, containerList.size());
        return containerList.get(containerChoice - 1);
    }

    private static Cargo selectCargo() {
        System.out.println("Available cargo:");
        List<Cargo> cargoList = new ArrayList<>(cargos.values());
        for (int i = 0; i < cargoList.size(); i++) {
            System.out.println((i + 1) + ". " + cargoList.get(i).getDescription() + " - " + cargoList.get(i).getTrackingId());
        }

        System.out.print("Select cargo (1-" + cargoList.size() + "): ");
        int cargoChoice = getUserChoice(1, cargoList.size());
        return cargoList.get(cargoChoice - 1);
    }

    private static Captain selectCaptain() {
        System.out.println("Available captains:");
        List<Captain> captainList = new ArrayList<>(captains.values());
        for (int i = 0; i < captainList.size(); i++) {
            System.out.println((i + 1) + ". " + captainList.get(i).getFullName());
        }

        System.out.print("Select captain (1-" + captainList.size() + "): ");
        int captainChoice = getUserChoice(1, captainList.size());
        return captainList.get(captainChoice - 1);
    }

    private static Worker selectWorker() {
        System.out.println("Available workers:");
        List<Worker> workerList = new ArrayList<>(workers.values());
        for (int i = 0; i < workerList.size(); i++) {
            System.out.println((i + 1) + ". " + workerList.get(i).getFullName() + " - " + workerList.get(i).getJobTitle());
        }

        System.out.print("Select worker (1-" + workerList.size() + "): ");
        int workerChoice = getUserChoice(1, workerList.size());
        return workerList.get(workerChoice - 1);
    }

    private static void initializeDemoData() {
        Port singaporePort = new Port("Singapore Port", "Singapore", PortType.CONTAINER, 10000, 50);
        Port rotterdamPort = new Port("Rotterdam Port", "Netherlands", PortType.CONTAINER, 15000, 75);

        ports.put(singaporePort.getPortId(), singaporePort);
        ports.put(rotterdamPort.getPortId(), rotterdamPort);

        LoadingArea singaporeLoadingArea1 = new LoadingArea("Singapore Loading Area 1", 500, true, true, true);
        LoadingArea singaporeLoadingArea2 = new LoadingArea("Singapore Loading Area 2", 300, false, false, false);
        LoadingArea rotterdamLoadingArea1 = new LoadingArea("Rotterdam Loading Area 1", 600, true, true, true);

        singaporePort.addLoadingArea(singaporeLoadingArea1);
        singaporePort.addLoadingArea(singaporeLoadingArea2);
        rotterdamPort.addLoadingArea(rotterdamLoadingArea1);

        Captain captain1 = new Captain(
                "John", "Smith", 
                LocalDate.of(1980, 5, 15), 
                "123 Main St, Singapore", 
                "+65-1234-5678", 
                "john.smith@email.com", 
                LocalDate.of(2010, 3, 10), 
                85000.0, 
                15
        );

        Worker worker1 = new Worker(
                "Jane", "Doe", 
                LocalDate.of(1990, 8, 22), 
                "456 Elm St, Singapore", 
                "+65-8765-4321", 
                "jane.doe@email.com", 
                LocalDate.of(2015, 6, 5), 
                45000.0, 
                "Operations", 
                "Crane Operator", 
                "Michael Johnson", 
                true
        );

        Worker worker2 = new Worker(
                "Bob", "Brown", 
                LocalDate.of(1985, 3, 30), 
                "789 Oak St, Rotterdam", 
                "+31-1234-5678", 
                "bob.brown@email.com", 
                LocalDate.of(2012, 9, 15), 
                50000.0, 
                "Logistics", 
                "Forklift Operator", 
                "Sarah Williams", 
                true
        );

        captains.put(captain1.getEmployeeId(), captain1);
        workers.put(worker1.getEmployeeId(), worker1);
        workers.put(worker2.getEmployeeId(), worker2);

        worker1.addSkill("Crane Operation");
        worker1.addSkill("Container Inspection");
        worker2.addSkill("Forklift Operation");
        worker2.addSkill("Inventory Management");

        captain1.addCertification("Master Mariner License");
        captain1.addCertification("Advanced Navigation");
        captain1.addLicense("International Maritime License");

        singaporePort.addWorker(worker1);
        rotterdamPort.addWorker(worker2);

        singaporeLoadingArea1.assignWorker(worker1);
        rotterdamLoadingArea1.assignWorker(worker2);

        Ship ship1 = new Ship("Ocean Explorer", ShipType.CONTAINER, 500, 15000.0);
        Ship ship2 = new Ship("Cargo Master", ShipType.BULK_CARRIER, 300, 12000.0);

        ships.put(ship1.getTrackingId(), ship1);
        ships.put(ship2.getTrackingId(), ship2);

        ship1.setCaptain(captain1);

        Cargo electronics = new Cargo(
                "Electronics", 
                5.0, 
                10.0, 
                false, 
                true, 
                false, 
                null, 
                "TechCorp Inc.", 
                "ElectroMart", 
                "123 Tech Blvd, Rotterdam, Netherlands"
        );

        Cargo furniture = new Cargo(
                "Furniture", 
                15.0, 
                30.0, 
                false, 
                false, 
                false, 
                null, 
                "FurnitureMakers Ltd.", 
                "Home Goods Store", 
                "456 Home St, Singapore"
        );

        Cargo perishableFood = new Cargo(
                "Perishable Food", 
                8.0, 
                12.0, 
                false, 
                false, 
                true, 
                LocalDateTime.now().plusDays(14), 
                "FreshFoods Inc.", 
                "Grocery Chain", 
                "789 Market St, Rotterdam, Netherlands"
        );

        cargos.put(electronics.getTrackingId(), electronics);
        cargos.put(furniture.getTrackingId(), furniture);
        cargos.put(perishableFood.getTrackingId(), perishableFood);

        Container container1 = new Container(ContainerType.FCL_STANDARD, 20.0, 6.0, 2.4, 2.6);
        Container container2 = new Container(ContainerType.FCL_REFRIGERATED, 25.0, 12.0, 2.4, 2.6);

        containers.put(container1.getTrackingId(), container1);
        containers.put(container2.getTrackingId(), container2);

        container1.addCargo(electronics);
        container1.addCargo(furniture);
        container2.addCargo(perishableFood);

        container1.seal();
        container2.seal();

        singaporePort.dockShip(ship1);
        rotterdamPort.dockShip(ship2);

        singaporeLoadingArea1.addContainer(container1);
        rotterdamLoadingArea1.addContainer(container2);
    }
}
