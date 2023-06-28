// Client code
public class command_x {
    public static void main(String[] args) {
        // Create receiver object
        EntertainmentSystem entertainmentSystem = new EntertainmentSystem();

        // Create concrete command objects
        Command turnOnCommand = new TurnOnCommand(entertainmentSystem);
        Command turnOffCommand = new TurnOffCommand(entertainmentSystem);
        Command changeChannelCommand = new ChangeChannelCommand(entertainmentSystem, 5);
        Command adjustVolumeCommand = new AdjustVolumeCommand(entertainmentSystem, 10);
        Command increaseVolume = new cheminiCommand(entertainmentSystem,999);
        // Create invoker object
        RemoteControl remoteControl = new RemoteControl();

        // Set and execute different commands
        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(changeChannelCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(adjustVolumeCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(increaseVolume);
        remoteControl.pressButton();
    }
}
// Command interface
interface Command {
    void execute();
}

// Receiver class
class EntertainmentSystem {
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

    void increaseVolume(int volume){
        System.out.println("mama chemini hehe" + volume);
    }
}

// Concrete command classes
class TurnOnCommand implements Command {
    private EntertainmentSystem system;

    TurnOnCommand(EntertainmentSystem system) {
        this.system = system;
    }

    public void execute() {
        system.turnOn();
    }
}

class TurnOffCommand implements Command {
    private EntertainmentSystem system;

    TurnOffCommand(EntertainmentSystem system) {
        this.system = system;
    }

    public void execute() {
        system.turnOff();
    }
}

class ChangeChannelCommand implements Command {
    private EntertainmentSystem system;
    private int channel;

    ChangeChannelCommand(EntertainmentSystem system, int channel) {
        this.system = system;
        this.channel = channel;
    }

    public void execute() {
        system.changeChannel(channel);
    }
}

class AdjustVolumeCommand implements Command {
    private EntertainmentSystem system;
    private int volume;

    AdjustVolumeCommand(EntertainmentSystem system, int volume) {
        this.system = system;
        this.volume = volume;
    }

    public void execute() {
        system.adjustVolume(volume);
    }
}

class cheminiCommand implements Command{
    private EntertainmentSystem system;
    private int volume;

    cheminiCommand(EntertainmentSystem system, int volume) {
        this.system = system;
        this.volume = volume;
    }
    @Override
    public void execute() {
        system.increaseVolume(volume);
    }
}
// Invoker class
class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}



