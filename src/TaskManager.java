import java.util.HashMap;
import java.util.ArrayList;
public class TaskManager {
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, SubTask> subtasks = new HashMap<>();

    private int uniqueId = 1;

    public ArrayList<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public Task getById(int id) {
        return tasks.get(id);

    }

    public void create(Task task) {
        for (Task u : tasks.values()) {
            if (u.getTask().equals(task.getTask())) {
                System.out.println("Задача занята");
                return;
            }
        }

        task.setId(uniqueId);
        uniqueId++;
        tasks.put(task.getId(), task);
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
        tasks.remove(id);

    }

    public void deleteAll() {
        tasks.clear();
    }

    private int uniqueEpicId = 1;
    public ArrayList<Task> getEpicAll() {
        return new ArrayList<>(subtasks.values());
    }

    public Task getEpicById(int id) {
        return subtasks.get(id);

    }

    public void createEpic(SubTask task) {

        subtasks.put(task.getId(), task);
    }



    public void deleteEpicById(int id) {
        subtasks.remove(id);

    }

    public void deleteEpicAll() {
        subtasks.clear();
    }


    private int uniqueSubTaskId = 1;
    public ArrayList<Task> getESubTaskAll() {
        return new ArrayList<>(subtasks.values());
    }

    public Task getESubTaskById(int id) {
        return subtasks.get(id);

    }

    public void createSubTask(SubTask task) {

        subtasks.put(task.getId(), task);
    }



    public void deleteSubTaskById(int id) {
        subtasks.remove(id);

    }

    public void deleteSubTaskAll() {
        subtasks.clear();
    }
}
