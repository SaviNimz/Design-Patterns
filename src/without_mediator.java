
import java.util.ArrayList;
import java.util.List;

// Colleague interface
interface User_x {

    void sendMessage(String message);
    void receiveMessage(String message);
}

// Concrete colleague
class ChatUser_y implements User_x {

    private String name;
    private List<User_x> users;

    public ChatUser_y(String name) {
        this.name = name;
        this.users = new ArrayList<>();
    }

    public void addUser(User_x user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sending message: " + message);
        for (User_x user : users) {
            if (user != this) {
                user.receiveMessage(message);
            }
        }
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Usage example
public class without_mediator {
    public static void main(String[] args) {
        ChatUser_y user1 = new ChatUser_y("User 1");
        ChatUser_y user2 = new ChatUser_y("User 2");
        ChatUser_y user3 = new ChatUser_y("User 3");

        user1.addUser(user2);
        user1.addUser(user3);

        user1.sendMessage("Hello, everyone!");
    }
}