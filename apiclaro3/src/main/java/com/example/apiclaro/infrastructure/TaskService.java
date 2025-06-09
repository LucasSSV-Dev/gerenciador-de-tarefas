package com.example.apiclaro.infrastructure;

import com.example.apiclaro.domain.Task;
import com.example.apiclaro.domain.TaskDetails;
import com.example.apiclaro.domain.TaskOutput;
import com.example.apiclaro.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    //Post Methods
    public void createTask(TaskDetails task) {
        Task newTask = new Task();
        newTask.setTitle(task.title());
        newTask.setDescription(task.description());
        newTask.setCompleted(task.completed());
        newTask.setCreatedAt(LocalDateTime.now());

        repository.save(newTask);
    }

    //Get Methods
    public List<TaskOutput> getTasks() {
        List<Task> taskList = repository.findAll();
        List<TaskOutput> output = new ArrayList<>();
        for (Task task : taskList){
            output.add(new TaskOutput(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedAt(), task.getUpdatedAt()));
        }
        return output;
    }

    public TaskOutput getTaskById(UUID id) {
        Task taskFound = repository.findById(id).orElse(null);
        if (taskFound == null){
            throw new RuntimeException("Task not found.");
        } else {
            TaskOutput output = new TaskOutput(taskFound.getId(), taskFound.getTitle(), taskFound.getDescription(), taskFound.getCompleted(), taskFound.getCreatedAt(), taskFound.getUpdatedAt());
            return output;
        }
    }

//    public List<TaskOutput> getTaskByCompleted() {
//        List<Task> taskList = repository.findTaskByCompleted();
//        List<TaskOutput> outputList = new ArrayList<>();
//        for (Task task : taskList){
//            outputList.add(new TaskOutput(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted(), task.getCreatedAt(), task.getUpdatedAt()));
//        }
//        return outputList;
//    }


    //Delete Methods
    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    //Patch Methods
    public TaskOutput editTaskStatus(UUID id) {
        Task taskFound = repository.findById(id).orElse(null);
        if (taskFound == null){
            throw new RuntimeException("Task not found.");
        }
        if (taskFound.getCompleted()){ // não simplifiquei para minha própria legibilidade! :D
            taskFound.setCompleted(false);
            taskFound.setUpdatedAt(LocalDateTime.now());
            repository.save(taskFound);
        } else {
            taskFound.setCompleted(true);
            taskFound.setUpdatedAt(LocalDateTime.now());
            repository.save(taskFound);
        }
        return new TaskOutput(taskFound.getId(), taskFound.getTitle(), taskFound.getDescription(), taskFound.getCompleted(), taskFound.getCreatedAt(), taskFound.getUpdatedAt());
    }

    //Put Methods
    public TaskOutput editTask(UUID id, TaskDetails task) {
        Task taskFound = repository.findById(id).orElse(null);
        if (taskFound == null){
            throw new RuntimeException("Task not found.");
        } else {
            taskFound = new Task(id, task.title(), task.description(), task.completed(), task.createdAt(), task.updatedAt());
            taskFound.setUpdatedAt(LocalDateTime.now());
            repository.save(taskFound);
        }
        return new TaskOutput(taskFound.getId(), taskFound.getTitle(), taskFound.getDescription(), taskFound.getCompleted(), taskFound.getCreatedAt(), taskFound.getUpdatedAt());
    }

}
