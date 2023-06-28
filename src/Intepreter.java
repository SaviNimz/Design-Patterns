

// Context class
class Context {
    private double temperature;

    public Context(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}

// Abstract expression class
interface Expression {
    double interpret(Context context);
}

// Terminal expression class for Celsius
class CelsiusExpression implements Expression {
    public double interpret(Context context) {
        return context.getTemperature();
    }
}

// Non-terminal expression class for Fahrenheit
class FahrenheitExpression implements Expression {
    private Expression celsiusExpression;

    public FahrenheitExpression(Expression celsiusExpression) {
        this.celsiusExpression = celsiusExpression;
    }

    public double interpret(Context context) {
        double celsiusTemperature = celsiusExpression.interpret(context);
        return celsiusTemperature * 9 / 5 + 32;
    }
}

// Usage example
public class Intepreter {
    public static void main(String[] args) {
        // Create the context with a Celsius temperature
        Context context = new Context(25.0);

        // Create the expressions
        Expression celsiusExpression = new CelsiusExpression();
        Expression fahrenheitExpression = new FahrenheitExpression(celsiusExpression);

        // Interpret and print the results
        System.out.println("Celsius: " + celsiusExpression.interpret(context)); // Output: Celsius: 25.0
        System.out.println("Fahrenheit: " + fahrenheitExpression.interpret(context)); // Output: Fahrenheit: 77.0
    }
}
