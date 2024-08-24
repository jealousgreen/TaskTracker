import java.util.ArrayList;
import java.util.Scanner;

public class TaskTracker {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String title, String description) {
        tasks.add(new Task(title, description));
    }

    public void removeTask(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                tasks.remove(task);
                break;
            }
        }
    }

    public void completeTask(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                task.setDescription("Completed");
                break;
            }
        }
    }

    public void displayTasks() {
        for (Task task : tasks) {
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println();
        }
    }


    public static void main(String[] args) {
        TaskTracker taskTracker;
        taskTracker = new TaskTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Complete task");
            System.out.println("4. Display tasks");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1 -> {
                    System.out.println("Enter task title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter task description:");
                    String description = scanner.nextLine();
                    taskTracker.addTask(title, description);
                }
                case 2 -> {
                    System.out.println("Enter task title to remove:");
                    String removeTitle = scanner.nextLine();
                    taskTracker.removeTask(removeTitle);
                }
                case 3 -> {
                    System.out.println("Enter task title to complete:");
                    String completeTitle = scanner.nextLine();
                    taskTracker.completeTask(completeTitle);
                }
                case 4 -> taskTracker.displayTasks();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }

}