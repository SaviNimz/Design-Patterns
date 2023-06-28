
import java.util.ArrayList;
import java.util.List;

// Item class representing an item in the shopping cart
class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// ShoppingCart class representing the aggregate
class ShoppingCart implements Iterable<Item> {
    private List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public java.util.Iterator<Item> iterator() {
        return items.iterator();
    }
}

// Client code
public class Iterator {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Shirt", 25.99));
        cart.addItem(new Item("Pants", 39.99));
        cart.addItem(new Item("Shoes", 79.99));
        cart.addItem(new Item("hello", 90.09));

        double total = 0;
        for (Item item : cart) {
            System.out.println("Item: " + item.getName() + ", Price: $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Total: $" + total);
    }
}
