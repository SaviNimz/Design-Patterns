

//if we did not implemented command pattern here code will look like below


class entertainmentSystem {
    void turnOn() {

        System.out.println("Entertainment system is turned on");
    }

    void turnOff() {
        System.out.println("Entertainment system is turned off");
    }

    void changeChannel(int channel) {
        System.out.println("Channel changed to " + channel);
    }

    void adjustVolume(int volume) {
        System.out.println("Volume adjusted to " + volume);
    }
}



// we will have to implement the methods inside the remote class

class remoteControl {
    private entertainmentSystem system;

    remoteControl(entertainmentSystem system) {
        this.system = system;
    }

    void pressButton(String button) {
        switch (button) {
            case "on":
                system.turnOn();
                break;
            case "off":
                system.turnOff();
                break;
            case "channel":
                int channel = 5; // example value
                system.changeChannel(channel);
                break;
            case "volume":
                int volume = 10; // example value
                system.adjustVolume(volume);
                break;
            default:
                System.out.println("Invalid button");
                break;
        }
    }
}


public class without_command  {
    public static void main(String[] args) {
        entertainmentSystem entertainmentSystem = new entertainmentSystem();
        remoteControl remoteControl = new remoteControl(entertainmentSystem);

        remoteControl.pressButton("on");
        remoteControl.pressButton("channel");
        remoteControl.pressButton("volume");
        remoteControl.pressButton("off");
    }
}