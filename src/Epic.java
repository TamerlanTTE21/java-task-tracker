import java.util.ArrayList;
import java.util.HashMap;
public class Epic extends Task {

    public Epic (String title, String description) {
        super(title, description);
    }
    private HashMap<Integer, SubTask> subtasks = new HashMap<>();

    public ArrayList<Task> getEpicAll() {
        return new ArrayList<>(subtasks.values());
    }

    public Task getEpicById(int id) {
        return subtasks.get(id);

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

}
