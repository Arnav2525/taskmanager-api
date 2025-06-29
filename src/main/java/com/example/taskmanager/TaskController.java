package com.example.taskmanager;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskManager manager = new TaskManager();

    @GetMapping
    public List<Task> getAllTasks() {
        return manager.getAllTasks();
    }

    @PostMapping
    public String addTask(@RequestBody Task task) {
        manager.addTask(task);
        return "✅ Task added: " + task.getName();
    }

   @DeleteMapping("/{id}")
public String deleteTask(@PathVariable int id) {
    if (manager.deleteTask(id - 1)) {
        return "🗑️ Task #" + id + " deleted";
    } else {
        return "❌ Task #" + id + " not found";
    }
}


    @PutMapping("/{id}/complete")
    public String completeTask(@PathVariable int id) {
        if (manager.completeTask(id - 1)) {
            return "✅ Task #" + id + " marked as complete.";
        } else {
            return "❌ Task #" + id + " not found";
        }
    }

    @GetMapping("/matrix")
    public Map<String, List<Task>> getMatrix() {
        return manager.getEisenhowerMatrix();
    }
}
