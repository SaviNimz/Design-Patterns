
import java.util.Objects;

// Request class representing a customer support ticket
class SupportTicket {
    private String description;
    private int priority;

    public SupportTicket(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}

// Handler interface
interface SupportHandler {
    void handleRequest(SupportTicket ticket);
    void setNextHandler(SupportHandler nextHandler);
}

// Concrete handler class to handle low priority tickets
class LowPrioritySupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void handleRequest(SupportTicket ticket) {
        if (ticket.getPriority() <= 3) {
            System.out.println("Low priority ticket handled by low priority support handler.");
            // Perform ticket handling logic
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Concrete handler class to handle medium priority tickets
class MediumPrioritySupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void handleRequest(SupportTicket ticket) {
        if (ticket.getPriority() > 3 && ticket.getPriority() <= 7) {
            System.out.println("Medium priority ticket handled by medium priority support handler.");
            // Perform ticket handling logic
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Concrete handler class to handle high priority tickets
class HighPrioritySupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void handleRequest(SupportTicket ticket) {
        if (ticket.getPriority() > 7) {
            System.out.println("High priority ticket handled by high priority support handler.");
            // Perform ticket handling logic
        } else if (nextHandler != null) {
            nextHandler.handleRequest(ticket);
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}

// Client code
public class chain_of_responsibilty  {
    public static void main(String[] args) {
        // Create the chain of responsibility
        // this handlers handle the priority of the requests
        SupportHandler lowPriorityHandler = new LowPrioritySupportHandler();
        SupportHandler mediumPriorityHandler = new MediumPrioritySupportHandler();
        SupportHandler highPriorityHandler = new HighPrioritySupportHandler();

            // this order is defined by us
        highPriorityHandler.setNextHandler(mediumPriorityHandler);
        mediumPriorityHandler.setNextHandler(lowPriorityHandler);

        // Create a support ticket
        SupportTicket ticket = new SupportTicket("Example ticket", 5);
        SupportTicket ticket1 = new SupportTicket("cheyyyyyy" , 2);

        // Send the ticket through the chain of responsibility
        mediumPriorityHandler.handleRequest(ticket);
        highPriorityHandler.handleRequest(ticket1);
    }
}