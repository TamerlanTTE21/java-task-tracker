
public class Main {
    public static void main(String[] args) {
        TaskManager userManager = new TaskManager();

        Task task = new Task("cleaning", "wash the floors");

        userManager.create(task);
        System.out.println(task.getId()); // 1

        Task user2 = new Task("cook", "pasta");
        userManager.create(user2);
        System.out.println(user2.getId()); // 2


        Task updatingUser = new Task("walk", "street");
        updatingUser.setId(1);
        userManager.update(updatingUser);



        for (Task u : userManager.getAll()) {
            System.out.println(u.getTask());
        }

        Task user3 = new Task("cook", "pasta");
        System.out.println(userManager.getAll().size()); // 2
        userManager.create(user3);
        System.out.println(userManager.getAll().size()); // 2

        Epic epic = new Epic("write", "book");

    }
}