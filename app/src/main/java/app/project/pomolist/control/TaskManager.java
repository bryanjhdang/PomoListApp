package app.project.pomolist.control;

import java.util.ArrayList;

import app.project.pomolist.model.Task;

/**
 * Singleton design pattern that contains a collection of tasks.
 */
public class TaskManager {
    private ArrayList<Task> taskList;

    private static TaskManager instance;
    public static TaskManager getInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    private TaskManager() {}

    private void addTask() {

    }

    private void completeTask() {

    }
}
