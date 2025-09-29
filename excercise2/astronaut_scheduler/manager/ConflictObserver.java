package manager;

import model.Task;

public class ConflictObserver implements Observer {
    @Override
    public void onConflict(model.Task newTask, model.Task conflictingTask) {
        System.out.println("Error: Task conflicts with existing task \"" + conflictingTask.getDescription() + "\".");
    }
}
