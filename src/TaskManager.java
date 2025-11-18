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
            if (u.getTitle().equals(task.getTitle())) {
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
            existingUser.setTitle(task.getTitle());
            existingUser.setDescription(task.getDescription());
        }
    }

    public void deleteById(int id) {
        tasks.remove(id);

    }

    public void deleteAll() {
        tasks.clear();
    }


    public ArrayList<Task> getEpicAll() {
        return new ArrayList<>(subtasks.values());
    }

    public Task getEpicById(int id) {
        return subtasks.get(id);

    }

    public void createEpic(Epic epic) {
        for (Epic e : epics.values()) {
            if (e.getTitle().equals(epic.getTitle())) {
                System.out.println("Задача занята");
                return;
            }
        }

        epic.setId(uniqueId);
        uniqueId++;

        epics.put(epic.getId(), epic);
    }

    public void epicUpdate(Epic epic) {
        Task existingUser = getEpicById(epic.getId());
        if (existingUser == null) {
            System.out.println("Задача с таким id не найден");
        } else {
            existingUser.setTitle(epic.getTitle());
            existingUser.setDescription(epic.getDescription());
        }
    }



    public void deleteEpicById(int id) {
        subtasks.remove(id);

    }

    public void deleteEpicAll() {
        subtasks.clear();
    }



    public ArrayList<Task> getESubTaskAll() {
        return new ArrayList<>(subtasks.values());
    }

    public Task getESubTaskById(int id) {
        return subtasks.get(id);

    }

    public void createSubTask(SubTask subtask) {
        for (SubTask s : subtasks.values()) {
            if (s.getTitle().equals(subtask.getTitle())) {
                System.out.println("Задача занята");
                return;
            }
        }
        subtask.setId(uniqueId);
        uniqueId++;
        subtasks.put(subtask.getId(), subtask);
    }

    public void subTaskUpdate(SubTask subtask) {
        Task existingUser = getESubTaskById(subtask.getId());
        if (existingUser == null) {
            System.out.println("Задача с таким id не найден");
        } else {
            existingUser.setTitle(subtask.getTitle());
            existingUser.setDescription(subtask.getDescription());
        }
    }



    public void deleteSubTaskById(int id) {
        subtasks.remove(id);

    }

    public void deleteSubTaskAll() {
        subtasks.clear();
    }
}
