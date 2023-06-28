
import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface ChatMediator {
    void sendMessage(String message, User_y user);
    void addUser(User_y user);
}

// Concrete mediator
class ChatMediatorImpl implements ChatMediator {
    private List<User_y> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User_y user) {
        for (User_y u : users) {
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User_y user) {
        users.add(user);
    }
}

// Colleague interface
interface User_y {
    void sendMessage(String message);
    void receiveMessage(String message);
}

// Concrete colleague
class ChatUser implements User_y {
    private String name;
    private ChatMediator mediator;

    public ChatUser(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sending message: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Usage example
public class MediatorExample {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User_y user1 = new ChatUser("User 1", mediator);
        User_y user2 = new ChatUser("User 2", mediator);
        User_y user3 = new ChatUser("User 3", mediator);

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.sendMessage("Hello, everyone!");
    }
}