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



    //Requisições HTTP:

    //Post Mappings
    @PostMapping
    public void createTask(@RequestBody TaskDetails task){
        service.createTask(task);
    }


    //Get Mappings
    @GetMapping
    public List<TaskOutput> getTasks(){
        return service.getTasks();
    }

    @GetMapping("{id}")
    public TaskOutput getTaskById(@PathVariable("id") UUID id){
        return service.getTaskById(id);
    }


    //Delete Mappings
    @DeleteMapping
    public void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") UUID id){
        service.deleteById(id);
    }


    //Patch Mappings
    @PatchMapping("{id}/status") //ESSE AQUI É PRA ALTERAR A CONCLUSÃO SEM ABRIR A TASK. TRANSFERIR ELA PRA AREA DE CONCLUÍDO.
    public TaskOutput editTaskStatus(@PathVariable UUID id){
        return service.editTaskStatus(id);
    }


    //Put Mappings
    @PutMapping("{id}") //TODA VEZ QUE ALGUEM ABRIR E ALTERAR QUALQUER CONTEÚDO VAI SER LANÇADO ESSE AQUI.
    public TaskOutput editTask(@PathVariable("id") UUID id,
                               @RequestBody TaskDetails task){
        return service.editTask(id, task);
    }





}
