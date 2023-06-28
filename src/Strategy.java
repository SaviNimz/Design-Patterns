import java.util.function.DoubleConsumer;

// Strategy interface
interface FlyBehavior {
    void fly();
}

// Concrete strategies
class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("Flying with wings");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("Cannot fly");
    }
}

class flyWithJet implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("fly with jets");
    }
}

// Context class
class Duck {
    private FlyBehavior flyBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performFly() {
        flyBehavior.fly();
    }
}

// Usage
public class Strategy {
    public static void main(String[] args) {
        Duck mallardDuck = new Duck();

        Duck chemini = new Duck();

        chemini.setFlyBehavior(new flyWithJet());
        chemini.performFly();

        chemini.setFlyBehavior(new FlyWithWings());
        chemini.performFly();

        // Set fly behavior dynamically
        mallardDuck.setFlyBehavior(new FlyWithWings());
        mallardDuck.performFly();

        // Change fly behavior dynamically
        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.performFly();
    }
}


