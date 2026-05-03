import java.util.List;

class Admin {
    private String adminID;
    private String name;
    private Operational operational;

    public Admin(String adminID, String name, Operational operational) {
        this.adminID = adminID;
        this.name = name;
        this.operational = operational;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getName() {
        return name;
    }

    public void addCar(Car car) {
        operational.addCar(car);
    }

    public void removeCar(Car car) {
        operational.removeCar(car);
    }

    public List<Rental> viewRentals() {
        return operational.getRentals();
    }
}

