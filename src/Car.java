class Car {
    private String carID;
    private String model;
    private String brand;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carID, String model, String brand, double basePricePerDay) {
        this.carID = carID;
        this.model = model;
        this.brand = brand;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true; // By default, the car is available
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void rent() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Car has been rented");
        }  else {
            System.out.println("Car is already rented");
        }
    }

    public void returnCar() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Car has been returned");
        } else {
            System.out.println("Car was not rented");
        }
    }

    public double calculatePrice(int daysRented) {
        return basePricePerDay * daysRented;
    }


}