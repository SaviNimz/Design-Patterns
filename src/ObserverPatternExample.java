
import java.util.ArrayList;
import java.util.List;

// Subject (Observable)
interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private double temperature;
    private List<Observer> observers; // we have an arraylist to store the observers

    public WeatherStation() {
        observers = new ArrayList<>();
        // when a Weather station is initialized its constructor creates a new array list to store observers
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer
interface Observer {
    void update(double temperature);
}

// Concrete Observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(double temperature) {
        System.out.println("User " + name + " received an update. Temperature is " + temperature + " degrees.");
    }
}

// Main class to test the pattern
public class ObserverPatternExample {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        User user1 = new User("Laknadi");
        User user2 = new User("disini");
        User chemini = new User("chemini");

        weatherStation.attach(user1);
        weatherStation.attach(user2);

        weatherStation.setTemperature(25.5);
        weatherStation.setTemperature(28.2);
        weatherStation.setTemperature(56);

        weatherStation.detach(user1);

        weatherStation.setTemperature(30.1);
    }
}