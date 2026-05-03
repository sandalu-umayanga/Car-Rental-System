class Main {
    public static void main(String[] args) {
        Operational operational = new Operational();
        Admin admin = new Admin("A-001", "Nora", operational);

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. Add car");
            System.out.println("2. Add customer");
            System.out.println("3. Rent car");
            System.out.println("4. Return car");
            System.out.println("5. View rentals");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": {
                    System.out.print("Car ID: ");
                    String carID = scanner.nextLine().trim();
                    System.out.print("Model: ");
                    String model = scanner.nextLine().trim();
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine().trim();
                    System.out.print("Base price per day: ");
                    double basePrice = Double.parseDouble(scanner.nextLine().trim());

                    Car car = new Car(carID, model, brand, basePrice);
                    admin.addCar(car);
                    System.out.println("Car added.");
                    break;
                }
                case "2": {
                    System.out.print("Customer name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Customer ID: ");
                    String customerID = scanner.nextLine().trim();

                    Customer customer = new Customer(name, customerID);
                    operational.addCustomer(customer);
                    System.out.println("Customer added.");
                    break;
                }
                case "3": {
                    System.out.print("Car ID: ");
                    String carID = scanner.nextLine().trim();
                    System.out.print("Customer ID: ");
                    String customerID = scanner.nextLine().trim();
                    System.out.print("Days: ");
                    int days = Integer.parseInt(scanner.nextLine().trim());

                    Car car = findCarById(operational, carID);
                    Customer customer = findCustomerById(operational, customerID);

                    if (car == null || customer == null) {
                        System.out.println("Car or customer not found.");
                        break;
                    }

                    Rental rental = operational.rentCar(car, customer, days);
                    if (rental == null) {
                        System.out.println("Rental failed. Car may be unavailable.");
                    } else {
                        double total = rental.getCar().calculatePrice(rental.getRentalDays());
                        System.out.println("Rental created. Total price: " + total);
                    }
                    break;
                }
                case "4": {
                    System.out.print("Car ID: ");
                    String carID = scanner.nextLine().trim();
                    Car car = findCarById(operational, carID);
                    if (car == null) {
                        System.out.println("Car not found.");
                    } else {
                        operational.returnCar(car);
                    }
                    break;
                }
                case "5": {
                    java.util.List<Rental> rentals = admin.viewRentals();
                    if (rentals.isEmpty()) {
                        System.out.println("No rentals recorded.");
                    } else {
                        for (Rental rental : rentals) {
                            System.out.println(
                                rental.getCustomer().getName() +
                                " rented " + rental.getCar().getBrand() +
                                " " + rental.getCar().getModel() +
                                " for " + rental.getRentalDays() + " days"
                            );
                        }
                    }
                    break;
                }
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    private static Car findCarById(Operational operational, String carID) {
        for (Rental rental : operational.getRentals()) {
            if (rental.getCar().getCarID().equals(carID)) {
                return rental.getCar();
            }
        }
        for (Car car : operational.getCars()) {
            if (car.getCarID().equals(carID)) {
                return car;
            }
        }
        return null;
    }

    private static Customer findCustomerById(Operational operational, String customerID) {
        for (Rental rental : operational.getRentals()) {
            if (rental.getCustomer().getCustomerID().equals(customerID)) {
                return rental.getCustomer();
            }
        }
        for (Customer customer : operational.getCustomers()) {
            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }
        return null;
    }
}
