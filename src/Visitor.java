interface Animal {
    void accept(AnimalVisitor visitor);
}

class Lion implements Animal {
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visitLion(this);
    }

}

class Elephant implements Animal {
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visitElephant(this);
    }
}

class Monkey implements Animal {
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visitMonkey(this);
    }
}


// defining visior classes

interface AnimalVisitor {
    void visitLion(Lion lion);
    void visitElephant(Elephant elephant);
    void visitMonkey(Monkey monkey);
}

class FeedingVisitor implements AnimalVisitor {
    @Override
    public void visitLion(Lion lion) {
        System.out.println("Feeding lion");
    }

    @Override
    public void visitElephant(Elephant elephant) {
        System.out.println("Feeding elephant");
    }

    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Feeding monkey");
    }
}

class CleaningVisitor implements AnimalVisitor {
    @Override
    public void visitLion(Lion lion) {
        System.out.println("Cleaning lion");
    }

    @Override
    public void visitElephant(Elephant elephant) {
        System.out.println("Cleaning elephant");
    }

    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Cleaning monkey");
    }
}

class MedicalVisitor implements AnimalVisitor {
    @Override
    public void visitLion(Lion lion) {
        System.out.println("Providing medical treatment to lion");
    }

    @Override
    public void visitElephant(Elephant elephant) {
        System.out.println("Providing medical treatment to elephant");
    }

    @Override
    public void visitMonkey(Monkey monkey) {
        System.out.println("Providing medical treatment to monkey");
    }
}



public class Visitor {
    public static void main(String[] args) {

        Animal lion = new Lion();
        Animal elephant = new Elephant();
        Animal monkey = new Monkey();

        AnimalVisitor feedingVisitor = new FeedingVisitor();
        AnimalVisitor cleaningVisitor = new CleaningVisitor();
        AnimalVisitor medicalVisitor = new MedicalVisitor();


        lion.accept(feedingVisitor);
        elephant.accept(cleaningVisitor);
        monkey.accept(medicalVisitor);
    }
}