package src;

import java.util.ArrayList;

public class WarehouseSystem {
    private final ArrayList<Robot> robots = new ArrayList<>();
    private final ArrayList<Customer> customers = new ArrayList<>();

    public boolean addRobot(Robot robot) {
        if (findRobot(robot.getSerialNumber()) != null) {
            return false;
        }
        robots.add(robot);
        return true;
    }

    public Robot findRobot(String serialNumber) {
        for (Robot robot : robots) {
            if (robot.getSerialNumber().equals(serialNumber)) {
                return robot;
            }
        }
        return null;
    }

    public boolean updateRobot(String currentSerialNumber, Robot updatedRobot) {
        int currentIndex = findRobotIndex(currentSerialNumber);
        if (currentIndex == -1) {
            return false;
        }

        Robot robotWithNewSerial = findRobot(updatedRobot.getSerialNumber());
        if (robotWithNewSerial != null && robotWithNewSerial != robots.get(currentIndex)) {
            return false;
        }

        robots.set(currentIndex, updatedRobot);
        return true;
    }

    public boolean deleteRobot(String serialNumber) {
        Robot robot = findRobot(serialNumber);
        if (robot == null) {
            return false;
        }
        robots.remove(robot);
        return true;
    }

    public ArrayList<Robot> getRobots() {
        return new ArrayList<>(robots);
    }

    public boolean addCustomer(Customer customer) {
        if (findCustomer(customer.getUserId()) != null) {
            return false;
        }
        customers.add(customer);
        return true;
    }

    public Customer findCustomer(String userId) {
        for (Customer customer : customers) {
            if (customer.getUserId().equals(userId)) {
                return customer;
            }
        }
        return null;
    }

    public boolean updateCustomer(String currentUserId, Customer updatedCustomer) {
        int currentIndex = findCustomerIndex(currentUserId);
        if (currentIndex == -1) {
            return false;
        }

        Customer customerWithNewId = findCustomer(updatedCustomer.getUserId());
        if (customerWithNewId != null && customerWithNewId != customers.get(currentIndex)) {
            return false;
        }

        customers.set(currentIndex, updatedCustomer);
        return true;
    }

    public boolean deleteCustomer(String userId) {
        Customer customer = findCustomer(userId);
        if (customer == null) {
            return false;
        }
        customers.remove(customer);
        return true;
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    private int findRobotIndex(String serialNumber) {
        for (int index = 0; index < robots.size(); index++) {
            if (robots.get(index).getSerialNumber().equals(serialNumber)) {
                return index;
            }
        }
        return -1;
    }

    private int findCustomerIndex(String userId) {
        for (int index = 0; index < customers.size(); index++) {
            if (customers.get(index).getUserId().equals(userId)) {
                return index;
            }
        }
        return -1;
    }
}
