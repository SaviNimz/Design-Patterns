import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Prototype interface
interface CloneableDocument {
    CloneableDocument clone();
    void display();
}

// Concrete prototype class
class Document implements CloneableDocument {
    String content;

    public Document(String content) {
        this.content = content;
    }

    @Override
    public CloneableDocument clone() {
        return new Document(this.content);
    }

    @Override
    public void display() {
        System.out.println("Document Content: " + this.content);
    }
}

// Client class
public class prototype {
    public static void main(String[] args) {
        // Create a prototype document
        Document prototypeDoc = new Document("Sample content");

        // Create a list to hold cloned documents
        List<CloneableDocument> clonedDocuments = new ArrayList<>();

        // Clone the prototype document and add to the list
        CloneableDocument clonedDoc1 = prototypeDoc.clone();
        clonedDocuments.add(clonedDoc1);
        clonedDoc1.display();

        // Modify the cloned document
        ((Document) clonedDoc1).content = "Modified content";
        clonedDoc1.display();

        // Clone another instance and add to the list
        CloneableDocument clonedDoc2 = prototypeDoc.clone();
        clonedDocuments.add(clonedDoc2);
        ((Document)clonedDoc2).content = "mama chemini";
        clonedDoc2.display();


        // Display all cloned documents
        System.out.println("\nAll Cloned Documents:");
        for (CloneableDocument doc : clonedDocuments) {
            doc.display();
        }
    }
}