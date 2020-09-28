package com.ualr.simpletasklist.model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TaskList {

    private Map<Integer, Task> tasks;
    private int highestTaskId;

    public TaskList() {
        this.tasks = new HashMap<>();
        this.highestTaskId = 0;
    }

    public Map<Integer, Task> getTasks() {
        return tasks;
    }

    public void setTasks(Map<Integer, Task> tasks) {
        this.tasks = tasks;
    }

    public void add(String description) {
        tasks.put(highestTaskId, new Task(description, false));
        highestTaskId = highestTaskId + 1;
    }

    public void delete(Integer id) {
        tasks.remove(id);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Integer, Task> entry : tasks.entrySet()) {
            if (!entry.getValue().isDone()) {
                builder.append(String.format(
                        Locale.US,
                        "%d - %s\n",
                        entry.getKey(),
                        entry.getValue().getDescription()));
            } else {
                builder.append(String.format(
                        Locale.US,
                        "%d - %s %s\n",
                        entry.getKey(),
                        entry.getValue().getDescription(),
                        "Done"));
            }

        }
        return builder.toString();
    }

    public void markDone(Integer id) {
        Task task = tasks.get(id);

        if (task != null) {
            task.setDone(true);
        }
    }

}
