package com.example.apiclaro.domain;

import com.example.apiclaro.domain.dto.TaskDetails;
import com.example.apiclaro.domain.dto.TaskOutput;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@EntityListeners(AuditingEntityListener.class)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean completed;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    public Task(TaskDetails taskDetails) {
        this.title = taskDetails.title();
        this.description = taskDetails.description();
        this.completed = taskDetails.completed();
    }

    // Métodos
    public TaskOutput toOutput(){
        return new TaskOutput(this.getId(),
                this.getTitle(),
                this.getDescription(),
                this.getCompleted(),
                this.getCreatedAt(),
                this.getUpdatedAt());
    }

    public void updateTask(TaskDetails taskDetails){
        this.setTitle(taskDetails.title());
        this.setDescription(taskDetails.description());
        this.setCompleted(taskDetails.completed());
    }




}
