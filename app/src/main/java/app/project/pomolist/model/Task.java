package app.project.pomolist.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class that represents a single task to complete.
 */
public class Task {
    String taskName;
    LocalDateTime dueDate;

    public Task(String taskName, LocalDateTime dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    public String getTaskDescription() {
        return taskName;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

}
