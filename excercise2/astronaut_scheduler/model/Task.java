package model;

import java.time.LocalTime;

public class Task {
    private String description;
    private LocalTime start;
    private LocalTime end;
    private String priority;
    private boolean completed;

    public Task(String description, LocalTime start, LocalTime end, String priority) {
        this.description = description;
        this.start = start;
        this.end = end;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() { return description; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void markCompleted() { this.completed = true; }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]%s",
                start, end, description, priority, completed ? " (Completed)" : "");
    }
}
