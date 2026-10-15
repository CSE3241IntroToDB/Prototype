package src;

public class Robot {
    private String serialNumber;
    private String model;
    private String status;
    private String warehouseLocation;
    private String manufacturer;
    private String year;
    private String warrantyExpiration;
    private String facilityId;
    private String primaryFunction;
    private String batteryAutonomy;
    private String sensor;
    private String rentalFee;
    private String insuranceReference;

    public Robot(String serialNumber, String model, String status, String warehouseLocation,
                 String manufacturer, String year, String warrantyExpiration, String facilityId,
                 String primaryFunction, String batteryAutonomy, String sensor, String rentalFee,
                 String insuranceReference) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.status = status;
        this.warehouseLocation = warehouseLocation;
        this.manufacturer = manufacturer;
        this.year = year;
        this.warrantyExpiration = warrantyExpiration;
        this.facilityId = facilityId;
        this.primaryFunction = primaryFunction;
        this.batteryAutonomy = batteryAutonomy;
        this.sensor = sensor;
        this.rentalFee = rentalFee;
        this.insuranceReference = insuranceReference;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWarehouseLocation() {
        return warehouseLocation;
    }

    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getWarrantyExpiration() {
        return warrantyExpiration;
    }

    public void setWarrantyExpiration(String warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getPrimaryFunction() {
        return primaryFunction;
    }

    public void setPrimaryFunction(String primaryFunction) {
        this.primaryFunction = primaryFunction;
    }

    public String getBatteryAutonomy() {
        return batteryAutonomy;
    }

    public void setBatteryAutonomy(String batteryAutonomy) {
        this.batteryAutonomy = batteryAutonomy;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(String rentalFee) {
        this.rentalFee = rentalFee;
    }

    public String getInsuranceReference() {
        return insuranceReference;
    }

    public void setInsuranceReference(String insuranceReference) {
        this.insuranceReference = insuranceReference;
    }

    @Override
    public String toString() {
        return "Robot"
                + "\n  Serial number: " + serialNumber
                + "\n  Model: " + model
                + "\n  Status: " + status
                + "\n  Warehouse location: " + warehouseLocation
                + "\n  Manufacturer: " + manufacturer
                + "\n  Year: " + year
                + "\n  Warranty expiration: " + warrantyExpiration
                + "\n  Facility ID: " + facilityId
                + "\n  Primary function: " + primaryFunction
                + "\n  Battery autonomy: " + batteryAutonomy
                + "\n  Sensor: " + sensor
                + "\n  Rental fee: " + rentalFee
                + "\n  Insurance reference: " + insuranceReference;
    }
}
