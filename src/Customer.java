package src;

public class Customer {
    private String userId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String startDate;
    private String status;
    private String facilityId;

    public Customer(String userId, String firstName, String lastName, String address, String phone,
                    String email, String startDate, String status, String facilityId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.startDate = startDate;
        this.status = status;
        this.facilityId = facilityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public String toString() {
        return "Customer"
                + "\n  User ID: " + userId
                + "\n  First name: " + firstName
                + "\n  Last name: " + lastName
                + "\n  Address: " + address
                + "\n  Phone: " + phone
                + "\n  Email: " + email
                + "\n  Start date: " + startDate
                + "\n  Status: " + status
                + "\n  Facility ID: " + facilityId;
    }
}
