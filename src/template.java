abstract class DocumentTemplate {
    // Common steps for all document types
    public void createDocument() {
        openDocument();
        addContent();
        saveDocument();
        closeDocument();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void openDocument();
    protected abstract void addContent();
    protected abstract void saveDocument();
    protected abstract void closeDocument();
}

class ReportDocument extends DocumentTemplate {
    @Override
    protected void openDocument() {
        System.out.println("Opening report document...");
    }

    @Override
    protected void addContent() {
        System.out.println("Adding report content...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving report document...");
    }

    @Override
    protected void closeDocument() {
        System.out.println("Closing report document...");
    }
}

class PresentationDocument extends DocumentTemplate {
    @Override
    protected void openDocument() {
        System.out.println("Opening presentation document...");
    }

    @Override
    protected void addContent() {
        System.out.println("Adding presentation content...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving presentation document...");
    }

    @Override
    protected void closeDocument() {
        System.out.println("Closing presentation document...");
    }
}

class SpreadsheetDocument extends DocumentTemplate {
    @Override
    protected void openDocument() {
        System.out.println("Opening spreadsheet document...");
    }

    @Override
    protected void addContent() {
        System.out.println("Adding spreadsheet content...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving spreadsheet document...");
    }

    @Override
    protected void closeDocument() {
        System.out.println("Closing spreadsheet document...");
    }
}

public class template {
    public static void main(String[] args) {
        DocumentTemplate report = new ReportDocument();
        report.createDocument();

        System.out.println("-------------------------");

        DocumentTemplate presentation = new PresentationDocument();
        presentation.createDocument();

        System.out.println("-------------------------");

        DocumentTemplate spreadsheet = new SpreadsheetDocument();
        spreadsheet.createDocument();
    }
}