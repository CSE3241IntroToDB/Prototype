
package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final String REPORT_MESSAGE =
            "This report will be implemented in a future checkpoint.";

    private final Scanner scanner = new Scanner(System.in);
    private final WarehouseSystem warehouseSystem = new WarehouseSystem();

    public static void main(String[] args) {
        new Main().run();
    }

    // MAIN MENU
    private void run() {
        System.out.println("Welcome to the Warehouse Robot System!");

        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1. Manage Robots");
            System.out.println("2. Manage Customers");
            System.out.println("3. Warehouse Services");
            System.out.println("4. Reports");
            System.out.println("0. Exit");

            String choice = promptMenuChoice();

            if (choice == null || choice.equals("0")) {
                break;
            }

            switch (choice) {
                case "1" -> manageRobots();
                case "2" -> manageCustomers();
                case "3" -> showServicesMenu();
                case "4" -> showReportsMenu();
                default -> System.out.println(
                        "Invalid choice. Please choose 0 through 4.");
            }
        }

        System.out.println("Goodbye.");
    }

    // ROBOT MENU
    private void manageRobots() {
        while (true) {
            System.out.println("\nRobot Records");
            System.out.println("1. Add robot");
            System.out.println("2. Edit robot");
            System.out.println("3. Delete robot");
            System.out.println("4. Search robot");
            System.out.println("5. List all robots");
            System.out.println("0. Back to main menu");

            String choice = promptMenuChoice();

            if (choice == null || choice.equals("0")) {
                return;
            }

            switch (choice) {
                case "1" -> addRobot();
                case "2" -> editRobot();
                case "3" -> deleteRobot();
                case "4" -> searchRobot();
                case "5" -> listRobots();
                default -> System.out.println(
                        "Invalid choice. Please choose 0 through 5.");
            }
        }
    }

    // ADD ROBOT
    private void addRobot() {
        String[] fields = promptFields(
                "Serial number",
                "Model",
                "Status",
                "Warehouse location",
                "Manufacturer",
                "Year",
                "Warranty expiration",
                "Facility ID",
                "Primary function",
                "Battery autonomy",
                "Sensor",
                "Rental fee",
                "Insurance reference");

        if (fields == null) {
            return;
        }

        if (fields[0].isEmpty()) {
            System.out.println("Serial number cannot be blank.");
            return;
        }

        Robot robot = new Robot(
                fields[0], fields[1], fields[2],
                fields[3], fields[4], fields[5],
                fields[6], fields[7], fields[8],
                fields[9], fields[10], fields[11],
                fields[12]);

        if (warehouseSystem.addRobot(robot)) {
            System.out.println("Robot added.");
        } else {
            System.out.println(
                    "A robot with that serial number already exists.");
        }
    }

    // EDIT ROBOT
    private void editRobot() {
        String serialNumber = prompt(
                "Enter the serial number of the robot to edit: ");

        if (serialNumber == null) {
            return;
        }

        Robot existing = warehouseSystem.findRobot(serialNumber);

        if (existing == null) {
            System.out.println("No robot found with that serial number.");
            return;
        }

        System.out.println("Press Enter to keep a value unchanged.");

        Robot updated = new Robot(
                promptForUpdate("Serial number", existing.getSerialNumber()),
                promptForUpdate("Model", existing.getModel()),
                promptForUpdate("Status", existing.getStatus()),
                promptForUpdate("Warehouse location", existing.getWarehouseLocation()),
                promptForUpdate("Manufacturer", existing.getManufacturer()),
                promptForUpdate("Year", existing.getYear()),
                promptForUpdate("Warranty expiration", existing.getWarrantyExpiration()),
                promptForUpdate("Facility ID", existing.getFacilityId()),
                promptForUpdate("Primary function", existing.getPrimaryFunction()),
                promptForUpdate("Battery autonomy", existing.getBatteryAutonomy()),
                promptForUpdate("Sensor", existing.getSensor()),
                promptForUpdate("Rental fee", existing.getRentalFee()),
                promptForUpdate("Insurance reference", existing.getInsuranceReference()));

        if (updated.getSerialNumber().isEmpty()) {
            System.out.println("Serial number cannot be blank.");
            return;
        }

        if (warehouseSystem.updateRobot(serialNumber, updated)) {
            System.out.println("Robot updated.");
        } else {
            System.out.println(
                    "That serial number is already used by another robot.");
        }
    }

    // DELETE ROBOT
    private void deleteRobot() {
        String serialNumber = prompt(
                "Enter the serial number of the robot to delete: ");

        if (serialNumber == null) {
            return;
        }

        if (warehouseSystem.deleteRobot(serialNumber)) {
            System.out.println("Robot deleted.");
        } else {
            System.out.println("No robot found with that serial number.");
        }
    }

    // SEARCH ROBOT
    private void searchRobot() {
        String serialNumber = prompt("Enter a robot serial number: ");

        if (serialNumber == null) {
            return;
        }

        Robot robot = warehouseSystem.findRobot(serialNumber);

        if (robot == null) {
            System.out.println("No robot found with that serial number.");
        } else {
            System.out.println(robot);
        }
    }

    // LIST ALL ROBOTS
    private void listRobots() {
        ArrayList<Robot> robots = warehouseSystem.getRobots();

        if (robots.isEmpty()) {
            System.out.println("There are no robot records.");
            return;
        }

        for (Robot robot : robots) {
            System.out.println("\n" + robot);
        }
    }

    // CUSTOMER MENU
    private void manageCustomers() {
        while (true) {
            System.out.println("\nCustomer Records");
            System.out.println("1. Add customer");
            System.out.println("2. Edit customer");
            System.out.println("3. Delete customer");
            System.out.println("4. Search customer");
            System.out.println("5. List all customers");
            System.out.println("0. Back to main menu");

            String choice = promptMenuChoice();

            if (choice == null || choice.equals("0")) {
                return;
            }

            switch (choice) {
                case "1" -> addCustomer();
                case "2" -> editCustomer();
                case "3" -> deleteCustomer();
                case "4" -> searchCustomer();
                case "5" -> listCustomers();
                default -> System.out.println(
                        "Invalid choice. Please choose 0 through 5.");
            }
        }
    }

    // ADD CUSTOMER
    private void addCustomer() {
        String[] fields = promptFields(
                "User ID",
                "First name",
                "Last name",
                "Address",
                "Phone",
                "Email",
                "Start date",
                "Status",
                "Facility ID");

        if (fields == null) {
            return;
        }

        if (fields[0].isEmpty()) {
            System.out.println("User ID cannot be blank.");
            return;
        }

        Customer customer = new Customer(
                fields[0], fields[1], fields[2],
                fields[3], fields[4], fields[5],
                fields[6], fields[7], fields[8]);

        if (warehouseSystem.addCustomer(customer)) {
            System.out.println("Customer added.");
        } else {
            System.out.println(
                    "A customer with that user ID already exists.");
        }
    }

    // EDIT CUSTOMER
    private void editCustomer() {
        String userId = prompt(
                "Enter the user ID of the customer to edit: ");

        if (userId == null) {
            return;
        }

        Customer existing = warehouseSystem.findCustomer(userId);

        if (existing == null) {
            System.out.println("No customer found with that user ID.");
            return;
        }

        System.out.println("Press Enter to keep a value unchanged.");

        Customer updated = new Customer(
                promptForUpdate("User ID", existing.getUserId()),
                promptForUpdate("First name", existing.getFirstName()),
                promptForUpdate("Last name", existing.getLastName()),
                promptForUpdate("Address", existing.getAddress()),
                promptForUpdate("Phone", existing.getPhone()),
                promptForUpdate("Email", existing.getEmail()),
                promptForUpdate("Start date", existing.getStartDate()),
                promptForUpdate("Status", existing.getStatus()),
                promptForUpdate("Facility ID", existing.getFacilityId()));

        if (updated.getUserId().isEmpty()) {
            System.out.println("User ID cannot be blank.");
            return;
        }

        if (warehouseSystem.updateCustomer(userId, updated)) {
            System.out.println("Customer updated.");
        } else {
            System.out.println(
                    "That user ID is already used by another customer.");
        }
    }

    // DELETE CUSTOMER
    private void deleteCustomer() {
        String userId = prompt(
                "Enter the user ID of the customer to delete: ");

        if (userId == null) {
            return;
        }

        if (warehouseSystem.deleteCustomer(userId)) {
            System.out.println("Customer deleted.");
        } else {
            System.out.println("No customer found with that user ID.");
        }
    }

    // SEARCH CUSTOMER
    private void searchCustomer() {
        String userId = prompt("Enter a customer user ID: ");

        if (userId == null) {
            return;
        }

        Customer customer = warehouseSystem.findCustomer(userId);

        if (customer == null) {
            System.out.println("No customer found with that user ID.");
        } else {
            System.out.println(customer);
        }
    }

    // LIST ALL CUSTOMERS
    private void listCustomers() {
        ArrayList<Customer> customers = warehouseSystem.getCustomers();

        if (customers.isEmpty()) {
            System.out.println("There are no customer records.");
            return;
        }

        for (Customer customer : customers) {
            System.out.println("\n" + customer);
        }
    }

    // WAREHOUSE SERVICES MENU
    private void showServicesMenu() {
        while (true) {
            System.out.println("\nWarehouse Services");
            System.out.println("1. Rent Robot");
            System.out.println("2. Return Equipment");
            System.out.println("3. Schedule Robot Delivery");
            System.out.println("4. Schedule Robot Pickup");
            System.out.println("0. Back to main menu");

            String choice = promptMenuChoice();

            if (choice == null || choice.equals("0")) {
                return;
            }

            switch (choice) {
                case "1" -> collectRentalDetails();
                case "2" -> collectReturnDetails();
                case "3" -> collectSchedulingDetails("delivery");
                case "4" -> collectSchedulingDetails("pickup");
                default -> System.out.println(
                        "Invalid choice. Please choose 0 through 4.");
            }
        }
    }

    // RENT ROBOT
    private void collectRentalDetails() {
        System.out.println("\nRent Robot");

        String customerId = prompt("Customer user ID: ");
        if (customerId == null) return;

        String serialNumber = prompt("Robot serial number: ");
        if (serialNumber == null) return;

        String rentalDate = prompt("Rental date: ");
        if (rentalDate == null) return;

        String expectedReturnDate = prompt("Expected return date: ");
        if (expectedReturnDate == null) return;

        System.out.println(
                "Rental request noted for customer " + customerId
                + ", robot " + serialNumber
                + ", from " + rentalDate
                + " through " + expectedReturnDate + ".");
    }

    // RETURN EQUIPMENT
    private void collectReturnDetails() {
        System.out.println("\nReturn Equipment");

        String customerId = prompt("Customer user ID: ");
        if (customerId == null) return;

        String serialNumber = prompt("Robot serial number: ");
        if (serialNumber == null) return;

        String returnDate = prompt("Return date: ");
        if (returnDate == null) return;

        System.out.println(
                "Return request noted for customer " + customerId
                + ", robot " + serialNumber
                + " on " + returnDate + ".");
    }

    // DELIVERY AND PICKUP
    private void collectSchedulingDetails(String action) {
        System.out.println("\nSchedule Robot " + capitalize(action));

        String customerId = prompt("Customer user ID: ");
        if (customerId == null) return;

        String serialNumber = prompt("Robot serial number: ");
        if (serialNumber == null) return;

        String driverlessCarId = prompt("Driverless car ID: ");
        if (driverlessCarId == null) return;

        String date = prompt(capitalize(action) + " date: ");
        if (date == null) return;

        System.out.println(
                "Robot " + action
                + " request noted for customer " + customerId
                + ", robot " + serialNumber
                + ", driverless car " + driverlessCarId
                + " on " + date + ".");
    }

    // REPORTS MENU - NOT IMPLEMENTED YET
    private void showReportsMenu() {
        while (true) {
            System.out.println("\nReports");
            System.out.println("1. Available Robots");
            System.out.println("2. Rental History");
            System.out.println("3. Maintenance History");
            System.out.println("0. Back to main menu");

            String choice = promptMenuChoice();

            if (choice == null || choice.equals("0")) {
                return;
            }

            switch (choice) {
                case "1", "2", "3" ->
                        System.out.println(REPORT_MESSAGE);

                default -> System.out.println(
                        "Invalid choice. Please choose 0 through 3.");
            }
        }
    }

    // INPUT HELPER METHODS

    private String prompt(String message) {
        System.out.print(message);

        if (!scanner.hasNextLine()) {
            return null;
        }

        return scanner.nextLine().trim();
    }

    private String promptMenuChoice() {
        return prompt("Choose an option: ");
    }

    private String[] promptFields(String... labels) {
        String[] fields = new String[labels.length];

        for (int index = 0; index < labels.length; index++) {
            fields[index] = prompt(labels[index] + ": ");

            if (fields[index] == null) {
                return null;
            }
        }

        return fields;
    }

    private String promptForUpdate(String fieldName, String currentValue) {
        String value = prompt(
                fieldName + " [" + currentValue + "]: ");

        if (value == null || value.isEmpty()) {
            return currentValue;
        }

        return value;
    }

    private String capitalize(String value) {
        return value.substring(0, 1).toUpperCase()
                + value.substring(1);
    }
}
