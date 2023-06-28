public class Duck_without_strategy {
    public static void main(String[] args) {
        Ducck mallardDucck = new Ducck(true);
        mallardDucck.performFly();

        Ducck rubberDucck = new Ducck(false);
        rubberDucck.performFly();
    }
}

class Ducck {
    private boolean canFly;

    public Ducck(boolean canFly) {
        this.canFly = canFly;
    }

    public void performFly() {
        if (canFly) {
            System.out.println("Flying with wings");
        } else {
            System.out.println("Cannot fly");
        }
    }
}

