
// State interface
interface TrafficLightState {
    void handleRequest();
}

// Concrete states
class RedLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Stop. Red Light.");
    }
}

class GreenLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Go. Green Light.");
    }
}

class YellowLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Prepare to stop. Yellow Light.");
    }
}

class cheminigeharamitta implements TrafficLightState{

    @Override
    public void handleRequest() {
        System.out.println("chemini maaru wenawa paara");
    }
}
// Context class
class TrafficLightController {
    private TrafficLightState currentState;

    public TrafficLightController() {
        // Start with the red light state
        currentState = new RedLightState();
    }

    // when this method is called state chages
    public void setState(TrafficLightState state) {
        currentState = state;
    }

    public void getState(){
        System.out.println("Current state is " + currentState.toString());
    }

    // this will give the output to the screen
    public void cheminige_aasawa() {

        currentState.handleRequest();
    }
}

// Usage
public class State {
    public static void main(String[] args) {
        TrafficLightController controller = new TrafficLightController();
        controller.cheminige_aasawa(); // Stop. Red Light.
        controller.getState();

        controller.setState(new YellowLightState());
        controller.cheminige_aasawa(); // Prepare to stop. Yellow Light.


        controller.setState(new GreenLightState());
        controller.getState();

        controller.setState(new cheminigeharamitta());

        controller.cheminige_aasawa(); // Go. Green Light.
        controller.getState();
    }
}