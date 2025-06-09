package com.example.apiclaro.web;

import com.example.apiclaro.domain.TaskDetails;
import com.example.apiclaro.domain.TaskOutput;
import com.example.apiclaro.infrastructure.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("task")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }


    //Post Mappings
    @PostMapping("new-task")
    public void createTask(@RequestBody TaskDetails task){
        service.createTask(task);
    }


    //Get Mappings
    @GetMapping("all")
    public List<TaskOutput> getTasks(){
        return service.getTasks();
    }

    @GetMapping("find/{id}")
    public TaskOutput getTaskById(@PathVariable("id") UUID id){
        return service.getTaskById(id);
    }

//    @GetMapping("find-completed")
//    public List<TaskOutput> getTaskByCompleted(){ return service.getTaskByCompleted(); }


    //Delete Mappings
    @DeleteMapping("delete-all")
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable("id") UUID id){
        service.deleteById(id);
    }


    //Patch Mappings
    @PatchMapping("status/{id}") //ESSE AQUI É PRA ALTERAR A CONCLUSÃO SEM ABRIR A TASK. TRANSFERIR ELA PRA AREA DE CONCLUÍDO.
    public TaskOutput editTaskStatus(@PathVariable UUID id){
        return service.editTaskStatus(id);
    }


    //Put Mappings
    @PutMapping("save/{id}") //TODA VEZ QUE ALGUEM ABRIR E ALTERAR QUALQUER CONTEÚDO VAI SER LANÇADO ESSE AQUI.
    public TaskOutput editTask(@PathVariable("id") UUID id,
                               @RequestBody TaskDetails task){
        return service.editTask(id, task);
    }





}
