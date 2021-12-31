package app.project.pomolist.model;

import androidx.annotation.NonNull;

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

    public String getTaskName() {
        return taskName;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    private String getTaskDescription() {
        if (dueDate == null) {
            return taskName;
        } else {
            return taskName + "\n" + dueDate;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return getTaskDescription();
    }
}
