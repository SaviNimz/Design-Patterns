
import java.util.ArrayList;
import java.util.List;

class TextEditor {
    private String content;

    public TextEditor() {
        this.content = "";
    }

    public void write(String text) {
        this.content += text;
    }

    public void printContent() {
        System.out.println("Current content: " + content);
    }

    public TextEditorMemento createMemento() {
        return new TextEditorMemento(content);
    }

    public void restoreFromMemento(TextEditorMemento memento) {
        this.content = memento.getContent();
    }
}

class TextEditorMemento {
    private String content;

    public TextEditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class TextEditorHistory {
    private List<TextEditorMemento> history;

    public TextEditorHistory() {
        this.history = new ArrayList<>();
    }

    public void push(TextEditorMemento memento) {
        history.add(memento);
    }

    public TextEditorMemento pop() {
        if (!history.isEmpty()) {
            int lastIndex = history.size() - 1;
            TextEditorMemento lastMemento = history.get(lastIndex);
            history.remove(lastIndex);
            return lastMemento;
        }
        return null;
    }
}

// Usage example
public class Memento {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        editor.write("Hello, ");

        history.push(editor.createMemento());

        editor.write("world!");
        editor.printContent(); // Output: Current content: Hello, world!

        history.push(editor.createMemento());

        editor.write(" How are you?");
        editor.printContent(); // Output: Current content: Hello, world! How are you?


        TextEditorMemento memento = history.pop(); // hello world
        TextEditorMemento memento1 = history.pop(); // hello,
        if (memento != null) {
            editor.restoreFromMemento(memento);
        }

        editor.printContent(); // Output: Current content: Hello, world!
    }
}