

public class SubTask extends Task {
    Epic epic;

    public SubTask(String title, String description, Epic epic) {
        super(title, description);
        this.epic = epic;
    }
}

