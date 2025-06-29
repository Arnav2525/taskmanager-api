package com.example.taskmanager;
public class Task {
    private String name;
    private boolean urgent;
    private boolean important;
    private boolean complete = false;

    public Task() {} // Required for JSON deserialization

    public Task(String name, boolean urgent, boolean important) {
        this.name = name;
        this.urgent = urgent;
        this.important = important;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isUrgent() { return urgent; }
    public void setUrgent(boolean urgent) { this.urgent = urgent; }

    public boolean isImportant() { return important; }
    public void setImportant(boolean important) { this.important = important; }

    public boolean isComplete() { return complete; }
    public void setComplete(boolean complete) { this.complete = complete; }

    public void markComplete() { this.complete = true; }

    @Override
    public String toString() {
        return (complete ? "[✓] " : "[ ] ") + name;
    }
}
