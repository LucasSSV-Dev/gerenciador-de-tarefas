package com.example.apiclaro.repository;

import com.example.apiclaro.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
//    List<Task> findTaskByCompleted();
}
