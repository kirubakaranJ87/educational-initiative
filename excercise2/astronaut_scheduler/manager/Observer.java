package manager;

import model.Task;

public interface Observer {
    void onConflict(Task newTask, Task conflictingTask);
}
