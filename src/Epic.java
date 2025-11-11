import java.util.HashMap;
import java.util.ArrayList;
public class Epic extends Task {

    public Epic (String task, String description) {
        super(task, description);
    }


    private HashMap<Integer, SubTask> subtasks = new HashMap<>();
    private int uniqueId = 1;
    public ArrayList<Task> getAll() {
        return new ArrayList<>(subtasks.values());
    }

    public Task getById(int id) {
        return subtasks.get(id);

    }

    public void create(SubTask task) {
        for (SubTask u : subtasks.values()) {
            if (u.getTask().equals(task.getTask())) {
                System.out.println("Задача занята");
                return;
            }
        }

        task.setId(uniqueId);
        uniqueId++;
        subtasks.put(task.getId(), task);
    }

    public void update(Task task) {
        Task existingUser = getById(task.getId());
        if (existingUser == null) {
            System.out.println("Задача с таким id не найден");
        } else {
            existingUser.setTask(task.getTask());
            existingUser.setDescription(task.getDescription());
        }
    }

    public void deleteById(int id) {
        subtasks.remove(id);

    }

    public void deleteAll() {
        subtasks.clear();
    }
}
