package com.kodilla.crud.tasks.controller;

import com.kodilla.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class TaskController {


    @GetMapping(path = "/tasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<>();
    }

    @GetMapping(path = "/tasks/{id}")
    public TaskDto getTask(@PathVariable("id") Long taskId) {
        return new TaskDto(1l, "New title", "New task");
    }

    @DeleteMapping(path = "/tasks/{id}")
    public void deleteTask(@PathVariable("id") Long taskId) {

    }

    @PutMapping(path = "/tasks")
    public TaskDto updateTask(@RequestBody TaskDto task) {
        return new TaskDto(1l, "Updated title", "Updatet task");
    }

    @PostMapping(path = "/tasks")
    public void createTask(@RequestBody TaskDto taskDto) {
    }
}
