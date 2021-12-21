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

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void completeTask() {

    }

    public static boolean isValidName(String taskName) {
        if (taskName.length() == 0) {
            return false;
        }

        boolean notAllSpaces = false;
        for (int i = 0; i < taskName.length(); i++) {
            if (taskName.charAt(i) != ' ') {
                notAllSpaces = true;
            }
        }
        return notAllSpaces;
    }
}
