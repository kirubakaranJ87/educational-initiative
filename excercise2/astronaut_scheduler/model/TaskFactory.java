package model;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public static Task createTask(String description, String start, String end, String priority) throws Exception {
        try {
            LocalTime s = LocalTime.parse(start);
            LocalTime e = LocalTime.parse(end);
            if (s.isAfter(e)) throw new Exception("Start time must be before end time");
            return new Task(description, s, e, priority);
        } catch (DateTimeParseException e) {
            throw new Exception("Error: Invalid time format.");
        }
    }
}
