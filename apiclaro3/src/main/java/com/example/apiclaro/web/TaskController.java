package com.example.apiclaro.web;

import com.example.apiclaro.domain.Task;
import com.example.apiclaro.domain.dto.TaskDetails;
import com.example.apiclaro.domain.dto.TaskOutput;
import com.example.apiclaro.infrastructure.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Void> createTask(@RequestBody TaskDetails task){
        //Não tem como dar erro. Vou validar apenas se tem conteúdo.
        Task taskSaved = service.createTask(task);
        if (taskSaved != null){

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(taskSaved.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.badRequest().build();
    }


    //Get Mappings
    @GetMapping
    public ResponseEntity<List<TaskOutput>> getTasks(){
        return ResponseEntity.ok(service.getTasks());
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskOutput> getTaskById(@PathVariable("id") UUID id){
        TaskOutput taskOutput = service.getTaskById(id);
        if (taskOutput == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.getTaskById(id));
    }


    //Delete Mappings
    @DeleteMapping
    public ResponseEntity<Void> deleteAll(){
        service.deleteAll();
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    //Patch Mappings
    @PatchMapping("{id}") //ESSE AQUI É PRA ALTERAR A CONCLUSÃO SEM ABRIR A TASK. TRANSFERIR ELA PRA AREA DE CONCLUÍDO.
    public ResponseEntity<TaskOutput> editTaskStatus(@PathVariable UUID id){
        TaskOutput taskOutput = service.editTaskStatus(id);
        if (taskOutput == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


    //Put Mappings
    @PutMapping("{id}") //TODA VEZ QUE ALGUEM ABRIR E ALTERAR QUALQUER CONTEÚDO VAI SER LANÇADO ESSE AQUI.
    public ResponseEntity<TaskOutput> editTask(@PathVariable("id") UUID id,
                               @RequestBody TaskDetails task){
        TaskOutput taskOutput = service.editTask(id, task);
        if (taskOutput == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskOutput);
    }





}
