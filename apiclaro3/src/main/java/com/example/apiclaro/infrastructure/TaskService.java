package com.example.apiclaro.infrastructure;

import com.example.apiclaro.domain.Task;
import com.example.apiclaro.domain.dto.TaskDetails;
import com.example.apiclaro.domain.dto.TaskOutput;
import com.example.apiclaro.repository.TaskRepository;
import com.example.apiclaro.validator.TaskValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskValidator validator;

    public TaskService(TaskRepository repository, TaskValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }


    //Post Methods
    public Task createTask(TaskDetails taskDetails) {
        boolean valid = validator.validateSave(taskDetails);
        if (valid){
            Task task = new Task(taskDetails);
            return repository.save(task);
        }
        return null;
    }

    //Get Methods
    public List<TaskOutput> getTasks() {
        List<Task> taskList = repository.findAll();

        List<TaskOutput> outputList = new ArrayList<>();
        for (Task task : taskList){
            outputList.add(task.toOutput());
        }

        return outputList;
    }

    public TaskOutput getTaskById(UUID id) {
        Optional<Task> taskOptional = repository.findById(id);
        if (taskOptional.isPresent()){
            return taskOptional.get().toOutput();
        }
        return null;
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
        return null; //TODO: Gerenciar Exceptions
    }

    //Put Methods
    public TaskOutput editTask(UUID id, TaskDetails task) {
        Optional<Task> taskOptional = repository.findById(id);
        if (taskOptional.isPresent()){
            Task taskFound = taskOptional.get();
            taskFound.updateTask(task);
            repository.save(taskFound);
            return taskFound.toOutput();
        }
        return null;
    }


}
