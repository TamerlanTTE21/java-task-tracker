import java.util.HashMap;
public class Epic extends Task {

    public Epic (String task, String description) {
        super(task, description);
    }

    private HashMap<Integer, SubTask> subtasks = new HashMap<>();

}
