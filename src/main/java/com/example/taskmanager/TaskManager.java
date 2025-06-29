package com.example.taskmanager;


import java.util.*;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            return true;
        }
        return false;
    }

    public boolean completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markComplete();
            return true;
        }
        return false;
    }

    public Map<String, List<Task>> getEisenhowerMatrix() {
        List<Task> doFirst = new ArrayList<>();
        List<Task> schedule = new ArrayList<>();
        List<Task> delegate = new ArrayList<>();
        List<Task> eliminate = new ArrayList<>();

        for (Task task : tasks) {
            if (task.isImportant() && task.isUrgent()) doFirst.add(task);
            else if (task.isImportant()) schedule.add(task);
            else if (task.isUrgent()) delegate.add(task);
            else eliminate.add(task);
        }

        Map<String, List<Task>> matrix = new LinkedHashMap<>();
        matrix.put("Do First", doFirst);
        matrix.put("Schedule", schedule);
        matrix.put("Delegate", delegate);
        matrix.put("Eliminate", eliminate);

        return matrix;
    }
}
