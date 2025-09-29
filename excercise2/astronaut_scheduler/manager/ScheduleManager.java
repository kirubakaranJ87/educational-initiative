package manager;

import model.Task;
import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private ScheduleManager() {}

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) instance = new ScheduleManager();
        return instance;
    }

    public void addObserver(Observer o) { observers.add(o); }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (isOverlap(t, task)) {
                notifyObservers(task, t);
                return;
            }
        }
        tasks.add(task);
        System.out.println("Task added successfully. No conflicts.");
    }

    public void removeTask(String description) {
        Optional<Task> found = tasks.stream()
                .filter(t -> t.getDescription().equalsIgnoreCase(description))
                .findFirst();
        if (found.isPresent()) {
            tasks.remove(found.get());
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.stream()
             .sorted(Comparator.comparing(Task::getStart))
             .forEach(System.out::println);
    }

    public void viewTasksByPriority(String priority) {
        tasks.stream()
             .filter(t -> t.getPriority().equalsIgnoreCase(priority))
             .forEach(System.out::println);
    }

    private boolean isOverlap(Task a, Task b) {
        return a.getStart().isBefore(b.getEnd()) && b.getStart().isBefore(a.getEnd());
    }

    private void notifyObservers(Task newTask, Task conflict) {
        for (Observer o : observers) o.onConflict(newTask, conflict);
    }
}
