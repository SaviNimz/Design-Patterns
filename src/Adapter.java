

// WeatherService interface (new interface)
interface WeatherService {
    double getTemperature();
    double getHumidity();

    double getAverage();
}

// LegacyWeatherService class (existing implementation)
class LegacyWeatherService {
    public double getCurrentTemperature() {
        // Fetch temperature from legacy API
        return 25.5;
    }

    public double getCurrentHumidity() {
        // Fetch humidity from legacy API
        return 65.0;
    }

    public double giveAverage(){
        return 45.6;
    }
}
//this adapter wraps the legacyWeatherService object and implements new methods in to it

// WeatherServiceAdapter class
class WeatherServiceAdapter implements WeatherService {
    private LegacyWeatherService legacyWeatherService;

    public WeatherServiceAdapter(LegacyWeatherService legacyWeatherService) {
        this.legacyWeatherService = legacyWeatherService;
    }

    @Override
    public double getTemperature() {
        return legacyWeatherService.getCurrentTemperature();
    }

    @Override
    public double getHumidity() {
        return legacyWeatherService.getCurrentHumidity();
    }

    @Override
    public double getAverage() {
        return legacyWeatherService.giveAverage();
    }


}

// Client code
public class Adapter {
    public static void main(String[] args) {
        LegacyWeatherService legacyWeatherService = new LegacyWeatherService();
        WeatherService weatherServiceAdapter = new WeatherServiceAdapter(legacyWeatherService);

        double temperature = weatherServiceAdapter.getTemperature();
        double humidity = weatherServiceAdapter.getHumidity();
        double avg = weatherServiceAdapter.getAverage();

        // we have two different methods that have been implemented on two different types of objects
        // so we can wrap one object in a adapter of other
        
        System.out.println("Temperature: " + temperature);
        System.out.println("Humidity: " + humidity);
        System.out.println("average is " + avg);
    }
}