import java.util.ArrayList;
import java.util.List;

class Operational {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public Operational() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        if (car != null) {
            cars.add(car);
        }
    }

    public void removeCar(Car car) {
        if (car != null) {
            cars.remove(car);
        }
    }

    public void addCustomer(Customer customer) {
        if (customer != null) {
            customers.add(customer);
        }
    }

    public Rental rentCar(Car car, Customer customer, int days) {
        if (car == null || customer == null || days <= 0) {
            return null;
        }
        if (!cars.contains(car)) {
            cars.add(car);
        }
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        if (!car.isAvailable()) {
            return null;
        }

        car.rent();
        Rental rental = new Rental(car, customer, days);
        rentals.add(rental);
        return rental;
    }

    public void returnCar(Car car) {
        if (car == null) {
            return;
        }
        car.returnCar();
    }

    public List<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
}
