package app.project.pomolist.model;

import java.time.LocalDate;

/**
 * Class that represents a single task to complete.
 */
public class Task {
    String taskDescription;
    String course;
    LocalDate dueDate;
    int difficulty;

    public Task(String taskDescription, String course, int difficulty, LocalDate dueDate) {
        this.taskDescription = taskDescription;
        this.course = course;
        this.difficulty = difficulty;
        this.dueDate = dueDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getCourse() {
        return course;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
