import manager.*;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictObserver());

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nAstronaut Daily Scheduler");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. View Tasks by Priority");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Start (HH:mm): ");
                    String start = sc.nextLine();
                    System.out.print("End (HH:mm): ");
                    String end = sc.nextLine();
                    System.out.print("Priority: ");
                    String priority = sc.nextLine();
                    try {
                        Task t = TaskFactory.createTask(desc, start, end, priority);
                        manager.addTask(t);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    manager.removeTask(sc.nextLine());
                    break;
                case 3:
                    manager.viewTasks();
                    break;
                case 4:
                    System.out.print("Priority to filter: ");
                    manager.viewTasksByPriority(sc.nextLine());
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
