
// Product class
class Car {
    private String brand;
    private String model;
    private int year;
    private int horsepower;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getInfo() {
        return "Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Horsepower: " + horsepower;
    }
}

// Builder interface
interface CarBuilder {
    void buildBrand(String brand);
    void buildModel(String model);
    void buildYear(int year);
    void buildHorsepower(int horsepower);
    Car getResult();
}

// we can create our own builder types by implementing the above interface

// Concrete builder
class CarBuilderImpl implements CarBuilder {
    private Car car;

    public CarBuilderImpl() {
        this.car = new Car();
    }

    public void buildBrand(String brand) {
        car.setBrand(brand);
    }

    public void buildModel(String model) {
        car.setModel(model);
    }

    public void buildYear(int year) {
        car.setYear(year);
    }

    public void buildHorsepower(int horsepower) {
        car.setHorsepower(horsepower);
    }

    public Car getResult() {
        return car;
    }
}

// Director
class CarManufacturer {
    private CarBuilder carBuilder;

    public CarManufacturer(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void constructCar() {
        carBuilder.buildBrand("Toyota");
        carBuilder.buildModel("Camry");
        carBuilder.buildYear(2022);
        carBuilder.buildHorsepower(203);
    }
}

// Usage example
public class Builder {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        CarManufacturer carManufacturer = new CarManufacturer(carBuilder);

        carManufacturer.constructCar();
        Car car = carBuilder.getResult();


        System.out.println(car.getInfo());
    }
}
