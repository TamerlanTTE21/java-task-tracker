import java.util.HashMap;
import java.util.ArrayList;
public class TaskManager {
    private HashMap<Integer, Task> users = new HashMap<>();
    private int uniqueId = 1;

    public ArrayList<Task> getAll() {
        return new ArrayList<>(users.values());
    }

    public Task getById(int id) {
        return users.get(id);

    }

    public void create(Task task) {
        for (Task u : users.values()) {
            if (u.getTask().equals(task.getTask())) {
                System.out.println("Логин занят");
                return;
            }
        }

        task.setId(uniqueId);
        uniqueId++;
        users.put(task.getId(), task);
    }

    public void update(Task task) {
        Task existingUser = getById(task.getId());
        if (existingUser == null) {
            System.out.println("Пользователь с таким id не найден");
        } else {
            existingUser.setTask(task.getTask());
            existingUser.setSubtask(task.getSubtask());
        }
    }

    public void deleteById(int id) {
        users.remove(id);

    }

    public void deleteAll() {
        users.clear();
    }
}
