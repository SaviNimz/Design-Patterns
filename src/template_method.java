
// Abstract base class representing a game
abstract class Game {
    // Template method defining the overall game flow
    public final void play() {
        initialize();   // Common initialization steps
        start();        // Specific game logic
        end();          // Common finalization steps
    }

    // Common initialization steps (default implementation)
    protected void initialize() {
        System.out.println("Game initialized.");
    }

    // Abstract method representing the specific game logic (to be implemented by subclasses)
    protected abstract void start();

    // Common finalization steps (default implementation)
    protected void end() {
        System.out.println("Game ended.");
    }
}

// Concrete game class: Chess
class Chess extends Game {
    // Implementing the specific game logic for Chess
    @Override
    protected void start() {
        System.out.println("Playing chess...");
    }
}

// Concrete game class: Monopoly
class Monopoly extends Game {
    // Implementing the specific game logic for Monopoly
    @Override
    protected void start() {
        System.out.println("Playing Monopoly...");
    }
}

// Main class to demonstrate the Template Method pattern
public class template_method {
    public static void main(String[] args) {
        Chess chessGame = new Chess();
        chessGame.play();   // Play Chess game

        System.out.println();

        Monopoly monopolyGame = new Monopoly();
        monopolyGame.play();    // Play Monopoly game
    }
}