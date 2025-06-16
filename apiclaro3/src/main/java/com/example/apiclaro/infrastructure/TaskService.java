package com.example.apiclaro.infrastructure;

import com.example.apiclaro.domain.Task;
 import com.example.apiclaro.domain.dto.TaskDetails;
import com.example.apiclaro.domain.dto.TaskOutput;
import com.example.apiclaro.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    //Post Methods
    public void createTask(TaskDetails taskDetails) {
        Task task = new Task(taskDetails);
        repository.save(task);
    }

    //Get Methods
    public List<TaskOutput> getTasks() {
        List<Task> taskList = repository.findAll();
        List<TaskOutput> output = new ArrayList<>();
        for (Task task : taskList){
            output.add(task.toOutput());
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


    //Delete Methods
    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    //Patch Methods
    public TaskOutput editTaskStatus(UUID id) {
        Optional<Task> taskOptional = repository.findById(id);
        if (taskOptional.isPresent()){
            Task taskFound = taskOptional.get();
            taskFound.setCompleted(!taskFound.getCompleted());
            repository.save(taskFound);
        }
        return null; //TODO: Gerenciar Exceptions, transformar em ResponseEntity
    }

    //Put Methods
    public TaskOutput editTask(UUID id, TaskDetails task) {
        Optional<Task> taskOptional = repository.findById(id);
        if (taskOptional.isPresent()){
            Task taskFound = taskOptional.get();
            taskFound.atualizarPeloDTO(task);
            repository.save(taskFound);
            return taskFound.toOutput();
        }
        return null; //TODO: Transformar tudo em ResponseEntity
    }


    //Reusabilidade:


}
