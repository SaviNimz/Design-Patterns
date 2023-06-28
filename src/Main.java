// Base coffee interface
interface Coffee {
    double getCost();
    String getDescription();
}

// Concrete coffee implementation
class SimpleCoffee implements Coffee {
    public double getCost() {
        return 1.0;
    }

    public String getDescription() {
        return "Simple coffee";
    }
}

// Decorator base class
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public double getCost() {
        return coffee.getCost();
    }

    public String getDescription() {
        return coffee.getDescription();
    }
}

// Concrete decorator classes
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

class Caramel extends CoffeeDecorator {
    public Caramel(Coffee coffee) {
        super(coffee);
    }

    public double getCost() {
        return super.getCost() + 0.75;
    }

    public String getDescription() {
        return super.getDescription() + ", Caramel";
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Coffee: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getCost());
        System.out.println("-----------------------------");
        coffee = new Milk(coffee);
        System.out.println("Coffee: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getCost());
        System.out.println("-----------------------------");
        coffee = new Caramel(coffee);
        System.out.println("Coffee: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getCost());
    }
}
