package com.example.apiclaro.validator;

import com.example.apiclaro.domain.dto.TaskDetails;
import org.springframework.stereotype.Component;

//Vou fazer pra que "true" seja válido e "false" seja inválido.
@Component
public class TaskValidator {
    //Não tem mto o que validar... Que saco =/
    public boolean validateSave(TaskDetails task){
        if (task.title().isEmpty() && task.description().isEmpty()){
            return false;
        }
        return true;
    }

}
